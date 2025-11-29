package com.app.inventory.service;

import com.app.inventory.dto.ProductRequest;
import com.app.inventory.dto.ProductResponse;
import com.app.inventory.entity.Product;
import com.app.inventory.exception.ProductNotFoundException;
import com.app.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = toEntity(productRequest);
        Product newProduct = productRepository.save(product);
        return toResponse(newProduct);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return toResponse(product);

    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product getProduct = productRepository.findById(id).orElseThrow((() -> new ProductNotFoundException(id)));

        getProduct.setCategory(productRequest.getCategory());
        getProduct.setName(productRequest.getName());
        getProduct.setPrice(productRequest.getPrice());
        getProduct.setStock(productRequest.getStock());

        return toResponse(productRepository.save(getProduct));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }


    private Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());

        return product;
    }



    private ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setCategory(product.getCategory());
        response.setStock(product.getStock());
        response.setPrice(product.getPrice());
        response.setCreatedAt(product.getCreatedAt());
        response.setUpdatedAt(product.getUpdatedAt());

        return response;
    }
}

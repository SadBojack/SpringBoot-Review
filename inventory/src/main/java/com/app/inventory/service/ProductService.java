package com.app.inventory.service;

import com.app.inventory.dto.ProductRequest;
import com.app.inventory.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProduct(Long id);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    void deleteProduct(Long id);

    List<ProductResponse> getProductByCategory(String category);

    List<ProductResponse> getProductByPriceBetween(Double min, Double max);

    Page<ProductResponse> findAllPageable(Pageable pageable);

}

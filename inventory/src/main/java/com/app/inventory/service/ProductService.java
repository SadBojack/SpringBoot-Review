package com.app.inventory.service;

import com.app.inventory.dto.ProductRequest;
import com.app.inventory.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProduct(Long id);

    List<ProductResponse> getAllProducts();
}

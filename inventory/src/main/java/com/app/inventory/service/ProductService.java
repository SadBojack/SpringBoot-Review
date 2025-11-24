package com.app.inventory.service;

import com.app.inventory.dto.ProductRequest;
import com.app.inventory.dto.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProduct(Long id);
}

package com.app.inventory.controller;

import com.app.inventory.dto.ProductRequest;
import com.app.inventory.dto.ProductResponse;
import com.app.inventory.entity.Product;
import com.app.inventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search/category")
    public ResponseEntity<List<ProductResponse>> findByCategory(@RequestParam String category) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByCategory(category));
    }

    @GetMapping("/search/price")
    public ResponseEntity<List<ProductResponse>> findByPriceBetween(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByPriceBetween(min,max));
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<ProductResponse>> getPaginatedProducts(@PageableDefault(size = 10, page = 0, sort="name")Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllPageable(pageable));
    }

}

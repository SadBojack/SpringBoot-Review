package com.app.inventory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;

    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;
}

package com.app.inventory.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private Long id;
    private String name;
    private String category;
    private Integer stock;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

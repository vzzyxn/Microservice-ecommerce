package com.example.ProductService.Dto;

import lombok.Builder;
import lombok.Data;

// when data is sent from the API to the client
@Data
@Builder
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String description;
}

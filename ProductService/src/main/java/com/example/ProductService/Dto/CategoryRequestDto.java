package com.example.ProductService.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

 // when data is received from the client to API
@Data
public class CategoryRequestDto {
    @NotBlank(message = "Category name is required")

    private String name;
    private String description;
}

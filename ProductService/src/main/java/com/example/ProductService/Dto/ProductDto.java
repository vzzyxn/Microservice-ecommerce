package com.example.ProductService.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;


@Data
public class ProductDto {

    @NotBlank (message = "Name must not be blank")
    private String name;
    @NotNull (message="Price must not be empty")
    @Positive
    private double price;
    @NotBlank (message="Description must not be blank")
    private String description;
}

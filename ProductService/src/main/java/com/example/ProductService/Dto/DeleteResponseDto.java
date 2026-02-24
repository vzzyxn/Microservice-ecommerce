package com.example.ProductService.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteResponseDto {
    public String message;
    public long deleteId;
}

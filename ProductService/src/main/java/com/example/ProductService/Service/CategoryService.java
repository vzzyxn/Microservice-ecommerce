package com.example.ProductService.Service;

import com.example.ProductService.Dto.CategoryRequestDto;
import com.example.ProductService.Dto.CategoryResponseDto;
import com.example.ProductService.Repository.CategoryRepository;

import java.awt.*;

public interface CategoryService {

        CategoryResponseDto createCategory(CategoryRequestDto request);

        List<CategoryResponseDto> getAllCategories();

        CategoryResponseDto getCategoryById(Long id);

        CategoryResponseDto updateCategory(Long id, CategoryRequestDto request);

        void deleteCategory(Long id);

    }
}

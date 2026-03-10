package com.example.ProductService.Service;

import com.example.ProductService.Dto.CategoryRequestDto;
import com.example.ProductService.Dto.CategoryResponseDto;
import com.example.ProductService.Model.Category;
import com.example.ProductService.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository CategoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        CategoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto request) {

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Category saved = CategoryRepository.save(category);

        return CategoryResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .build();
    }
    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return CategoryRepository.findAll()
                .stream()
                .map(category -> CategoryResponseDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .description(category.getDescription())
                        .build())
                .toList();
    }
    @Override
    public CategoryResponseDto getCategoryById(Long id) {

        Category category = CategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    @Override
    public CategoryResponseDto updateCategory(Long id, CategoryRequestDto request) {
        return null;
    }
    @Override
    public void deleteCategory(Long id) {

        Category category = CategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        CategoryRepository.delete(category);
    }
}

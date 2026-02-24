package com.example.ProductService.Service;


import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Exception.ProductNotFoundException;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save((product));
    }
    @Override
    //to get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    //to get product by id
    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No product id found with " + id));
    }
    //to update product
    public Product updateProduct(long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No product id found with " + id));
        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setDescription(productDto.getDescription());
        return productRepository.save(existingProduct);
    }
    //to delete product
    public void deleteProduct(long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("No product id found with id" + id));
        productRepository.delete(existingProduct);
    }
}

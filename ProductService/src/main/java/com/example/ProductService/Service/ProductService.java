package com.example.ProductService.Service;

import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product saveProduct(Product product);

    Product updateProduct(long id, ProductDto productDto);

    void deleteProduct(long id);
}

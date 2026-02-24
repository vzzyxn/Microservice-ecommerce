package com.example.ProductService.Repository;

import com.example.ProductService.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

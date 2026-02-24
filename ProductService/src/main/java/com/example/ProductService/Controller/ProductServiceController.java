package com.example.ProductService.Controller;

import com.example.ProductService.Dto.DeleteResponseDto;
import com.example.ProductService.Dto.ProductDto;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/products")
public class ProductServiceController {
    private final ProductService productService;

    public ProductServiceController(ProductService productService) {
        this.productService = productService;
    }
    //to create products
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(parseDto(productDto)));
    }
    //parsing dto
    private Product parseDto(ProductDto productDto) {
        Product p = new Product();
        p.setName(productDto.getName());
        p.setPrice(productDto.getPrice());
        p.setDescription(productDto.getDescription());

        return p;
    }
    //get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    //get products by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //updating product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }
    //deleting product and getting data deleted response
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponseDto> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        DeleteResponseDto deleteResponse = new DeleteResponseDto("Product deleted successfully", id);
        return ResponseEntity.ok(deleteResponse);
    }
}

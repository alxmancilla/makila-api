package org.makila.api.controller.postgresql;

import org.makila.api.model.postgresql.Product;
import org.makila.api.service.postgresql.CustomerService;
import org.makila.api.service.postgresql.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }  

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String title) {
        return ResponseEntity.ok(productService.searchProducts(title));
    }    

    @GetMapping("/category")
    public ResponseEntity<List<Product>> searchProductsByCategory(@RequestParam Integer category) {
        return ResponseEntity.ok(productService.searchProductsByCategory(category));
    }    
}
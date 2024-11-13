package org.makila.api.controller.postgresql;

import org.makila.api.model.postgresql.Product;
import org.makila.api.service.postgresql.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    
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
    
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Product>> getProductsByYear(@PathVariable Integer year) {
        return ResponseEntity.ok(productService.getProductsByYear(year));
    }
    
}
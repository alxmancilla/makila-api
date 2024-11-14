package org.makila.api.controller.postgresql;

import org.makila.api.model.postgresql.Product;
import org.makila.api.service.postgresql.ProductService;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pg/product")
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
    
    @GetMapping("/popular")
    public List<Product> getPopularProducts(
            @RequestParam String category,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return productService.getPopularProducts(category, startDate, endDate);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(productService.getProductsByTitle(title));
    }
    
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/state/{state}")
    public List<Product> getProductsByState(@PathVariable String state) {
        return productService.getProductsByState(state);
    }
}
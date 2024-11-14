package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Product;
import org.makila.api.repository.postgresql.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }
    
    public List<Product> searchProducts(String title) {
        return productRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Product> searchProductsByCategory(Integer category) {
        return productRepository.findByCategoryContainingIgnoreCase(category);
    }
    
}
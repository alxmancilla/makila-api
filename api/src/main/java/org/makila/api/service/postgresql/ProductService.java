package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Product;
import org.makila.api.repository.postgresql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    
    public List<Product> getPopularProducts(String category, LocalDate starDate, LocalDate endDate) {
        return productRepository.popularProductsByCategoryAndPeriod(category, starDate, endDate);
    }

    public List<Product> getProductsByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
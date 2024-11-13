package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Product;
import org.makila.api.repository.postgresql.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    
    public List<Product> getProductsByYear(Integer year) {
        return productRepository.findByReleaseYear(year);
    }
    
}
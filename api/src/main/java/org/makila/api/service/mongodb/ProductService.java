package org.makila.api.service.mongodb;

import java.util.List;

import org.makila.api.model.mongodb.ProductsEntity;
import org.makila.api.repository.mongodb.ProductsRepository;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productRepository;

    public List<ProductsEntity> getProducts(String category) {
        if (category != null) {
            return productRepository.findAll();
        } else {
            return productRepository.findByCategory(category);
        }
    }

    public ProductsEntity getProductById(ObjectId id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductsEntity> searchProducts(String title) {
        return productRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<ProductsEntity> getProductsByYear(Integer year) {
        return productRepository.findByReleaseYear(year);
    }
}

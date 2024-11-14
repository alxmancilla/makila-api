package org.makila.api.service.mongodb;

import java.util.List;

import org.makila.api.model.mongodb.ProductsEntity;
import org.makila.api.repository.mongodb.ProductsRepositoryMdb;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceMdb {
    private final ProductsRepositoryMdb productRepository;

    public List<ProductsEntity> getProducts(Integer category) {
        if (category != null) {
            return productRepository.findByCategory(category);
        } else {
            return productRepository.findAll();
        }
    }

    public ProductsEntity getProductById(Integer id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // public List<ProductsEntity> searchProducts(String title) {
    //     return productRepository.findByTitleContainingIgnoreCase(title);
    // }
    
    // public List<ProductsEntity> getProductsByYear(Integer year) {
    //     return productRepository.findByReleaseYear(year);
    // }
}

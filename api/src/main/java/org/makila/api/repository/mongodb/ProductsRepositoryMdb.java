package org.makila.api.repository.mongodb;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.makila.api.model.mongodb.ProductsEntity;

import java.util.List;

import org.bson.types.ObjectId;

/**
* Generated by MongoDB Relational Migrator 
* https://www.mongodb.com/products/relational-migrator 
* Collection: products
* Language: Java
* Template: POJO
* Generated on 11/13/24

*/
public interface ProductsRepositoryMdb extends MongoRepository<ProductsEntity, Integer> {
    // List<ProductsEntity> findByTitleContainingIgnoreCase(String title);
    // List<ProductsEntity> findByReleaseYear(Integer year);
    
    @Query("{ 'category' : ?0 }")
    List<ProductsEntity> findByCategory(Integer category);
}
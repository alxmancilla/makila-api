package org.makila.api.controller.mongodb;

import java.util.List;

import org.bson.types.ObjectId;
import org.makila.api.model.mongodb.ProductsEntity;
import org.makila.api.service.mongodb.ProductServiceMdb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mdb/product")
@RequiredArgsConstructor
public class ProductControllerMdb {
    private final ProductServiceMdb productService;

    @GetMapping
    public ResponseEntity<List<ProductsEntity>> getProducts(@RequestParam(required = false) String category) {
        return ResponseEntity.ok(productService.getProducts(category));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductsEntity> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    
    // @GetMapping("/search")
    // public ResponseEntity<List<ProductsEntity>> searchProducts(@RequestParam String title) {
    //     return ResponseEntity.ok(productService.searchProducts(title));
    // }
    
    // @GetMapping("/year/{year}")
    // public ResponseEntity<List<ProductsEntity>> getProductsByYear(@PathVariable Integer year) {
    //     return ResponseEntity.ok(productService.getProductsByYear(year));
    // }
    
    // @GetMapping("/rental-rate")
    // public ResponseEntity<List<ProductsEntity>> getProductsWithinRentalRate(@RequestParam Double maxRate) {
    //     return ResponseEntity.ok(productService.getProductsWithinRentalRate(maxRate));
    // }
}

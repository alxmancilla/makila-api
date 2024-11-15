package org.makila.api.repository.postgresql;

import org.makila.api.model.postgresql.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE title ~ :title", nativeQuery = true)
    List<Product> findByTitleContainingIgnoreCase(String title);
    @Query(value = "SELECT * FROM products WHERE title ~ :title", nativeQuery = true)
    List<Product> searchProducts(@RequestParam String title);
    @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
    List<Product> findByCategoryContainingIgnoreCase(Integer category);
}
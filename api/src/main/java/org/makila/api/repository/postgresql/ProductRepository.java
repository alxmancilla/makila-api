package org.makila.api.repository.postgresql;

import org.makila.api.model.postgresql.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContainingIgnoreCase(String title);
    List<Product> findByReleaseYear(Integer year);
   
}
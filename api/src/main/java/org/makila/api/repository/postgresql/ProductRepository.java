package org.makila.api.repository.postgresql;

import org.makila.api.model.postgresql.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContainingIgnoreCase(String title);
    List<Product> findByTitle(String title);

    @Query(value = """
        SELECT p FROM Product p 
        JOIN OrderLine o ON p.id = o.prodId
        WHERE p.category = :category
        AND o.orderDate BETWEEN :startDate AND :endDate
        GROUP BY p.id, p.category, p.title, p.actor, p.price, p.special, p.commonProdId, p.categoryName
        ORDER BY COUNT(o.prodId) DESC
    """)
    List<Product> popularProductsByCategoryAndPeriod(
            @Param("category") String category,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("SELECT p FROM Product p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Product> searchProductsByTitle(@Param("title") String title);

    List<Product> findByCategory(@Param("category") String category);

    @Query(value = """
        WITH ranked_products AS (
              SELECT (delivery_info  -> 'address' ->> 'state') AS state,
                      title,
                FROM customers
                GROUP BY (delivery_info  -> 'address' ->> 'state')
            ),
            top_states AS (
                SELECT state
                FROM state_counts
                ORDER BY count DESC
                LIMIT 5
            )
            SELECT *
            FROM customers
            WHERE (delivery_info  -> 'address' ->> 'state') IN (SELECT state FROM top_states)
    """)
    List<Product> findByState(@Param("state") String state);

}
package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "category", nullable = false)
    private Integer category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "actor")
    private String actor;

    @Column(name = "price", precision = 10, scale = 2) // Specify precision and scale for decimals
    private BigDecimal price;

    @Column(name = "special")
    private Integer special;

    @Column(name = "commonProdId")
    private Integer commonProdId;

    @Column(name = "categoryname")
    private String categoryName;
}

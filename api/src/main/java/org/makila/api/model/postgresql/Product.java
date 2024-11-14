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
    @Column(name = "prod_id", nullable = false)
    private Integer id;
    @Column(name = "category", nullable = false)
    private Integer category;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "actor", nullable = false, length = 50)
    private String actor;
    @Column(name = "price", nullable = false, precision = 12, scale = 2)
    private BigDecimal price;
    @Column(name = "special")
    private Short special;
    @Column(name = "common_prod_id", nullable = false)
    private Integer commonProdId;
    @Column(name = "description", columnDefinition = "text")
    private String description;
}

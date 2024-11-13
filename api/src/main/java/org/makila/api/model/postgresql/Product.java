package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    
    private String title;
    private String description;
    
    @Column(name = "release_year")
    private Integer releaseYear;
    
    @Column(name = "rental_duration")
    private Integer rentalDuration;
    
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    
    private Integer length;
    
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    
    private String rating;
    
    @Column(name = "special_features")
    private String specialFeatures;
    
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}

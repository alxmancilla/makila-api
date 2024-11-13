package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orderlines")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderlineid")
    private Integer id;
    
    @Column(name = "orderid")
    private Integer orderId;    
    
    @Column(name = "prod_id")
    private Integer prodId;    
     
    @Column(name = "quantity")
    private Integer quantity;
      
    @Column(name = "orderdate")
    private LocalDateTime orderDate;
}

package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "orderlines")
public class OrderLine {
    @Id
    @Column(name = "orderlineid")
    private Integer id;
      
    @Column(name = "prod_id")
    private Integer prodId;    
     
    @Column(name = "quantity")
    private Integer quantity;
      
    @Column(name = "orderdate")
    private LocalDateTime orderDate;

//    @Column(name = "orderid")
//    private Integer orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid")
    private Order order;
     
}

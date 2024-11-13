package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer id;
    
    @Column(name = "customerid")
    private Integer customerId;    
    
    @Column(name = "netamount")
    private BigDecimal netAmount;
    
    @Column(name = "tax")
    private BigDecimal tax;
   
    @Column(name = "totalamount")
    private BigDecimal totalAmount;
     
    @Column(name = "orderdate")
    private LocalDateTime orderDate;
   
    // @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderLine> items;
}

package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orderlines")
public class OrderLine {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orderid", insertable = false, nullable = false)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @Getter(onMethod = @__( @JsonIgnore))
//    @Setter
    private Order order;
     
}

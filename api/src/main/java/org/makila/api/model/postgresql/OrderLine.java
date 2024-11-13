package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    
    // @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinColumn(name = "orderid")
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // @Getter(onMethod = @__( @JsonIgnore))
    // @Setter
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_orderid"), name="orderid", referencedColumnName = "orderid", columnDefinition = "int")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable = false, updatable = false, nullable = false)
    private Order order;
    
}

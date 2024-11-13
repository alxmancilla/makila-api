package org.makila.api.model.postgresql;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.bson.types.ObjectId;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private ObjectId id;

    @Column(name = "orderid", nullable = false)
    private Integer orderId;

    @Column(name = "orderdate", nullable = false)
    private LocalDate orderDate;

    @Column(name = "customerid", nullable = false)
    private Integer customerId;

    @Column(name = "netamount", nullable = false, precision = 10, scale = 2)
    private BigDecimal netAmount;

    @Column(name = "tax", nullable = false, precision = 10, scale = 2)
    private BigDecimal tax;

    @Column(name = "totalamount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;
   
    // @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId")
    private Set<OrderLine> items;
}

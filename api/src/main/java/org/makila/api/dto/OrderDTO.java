package org.makila.api.dto;

import lombok.Data;
import java.util.List;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Integer customerId;    
    private BigDecimal netAmount;
    private BigDecimal tax;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private List<OrderItemDTO> items;
}



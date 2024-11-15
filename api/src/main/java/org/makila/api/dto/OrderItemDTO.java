package org.makila.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderItemDTO {
    private Integer id;
    private Integer prodId;    
    private Integer quantity;  
    private LocalDateTime orderDate;    
}


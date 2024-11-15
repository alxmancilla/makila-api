package org.makila.api.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Integer id;
    private Integer prodId;    
    private Integer quantity;  
    private LocalDateTime orderDate;
    
    public void setId(Integer id) {
        this.id = id;
    }
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public Integer getId() {
        return id;
    }
    public Integer getProdId() {
        return prodId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }   


     
}


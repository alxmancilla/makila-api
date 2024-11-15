package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.model.postgresql.OrderLine;
import org.makila.api.repository.postgresql.CustomerRepository;
import org.makila.api.repository.postgresql.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import org.makila.api.dto.*;
import java.util.Set;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }


    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerId(orderDTO.getCustomerId());
        order.setNetAmount(orderDTO.getNetAmount());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTax(orderDTO.getTax());
        order.setTotalAmount(orderDTO.getTotalAmount());
        
        for (OrderItemDTO itemDTO : orderDTO.getItems()) {
            OrderLine item = new OrderLine();
            item.setId(itemDTO.getId());
            item.setQuantity(itemDTO.getQuantity());
            item.setProdId(itemDTO.getProdId());
            item.setOrderDate(itemDTO.getOrderDate());
            order.addItem(item);
        }
        return orderRepository.save(order);
    }

    /*
    public Order saveOrder(Order order) {
        System.out.println("before save Order: " + order);
        return this.orderRepository.save(order); 
    } 
*/

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
}
package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.repository.postgresql.OrderLineRepository;
import org.makila.api.repository.postgresql.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired  
    private OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }
    
    public List<Order> getOrdersBetweenOrderDates(LocalDateTime minDate, LocalDateTime maxDate) {
        return orderRepository.findOrdersBetweenOrderDates(minDate, maxDate);
    }

    @Transactional (rollbackFor = Exception.class)
    public Order addOrder(Order order) {
        System.out.println("before save Order: " + order);
        Order orderSavedToDB = this.orderRepository.save(order);
        System.out.println("after save Order: " + orderSavedToDB);
        entityManager.flush();
    
        orderSavedToDB.getItems().forEach(item -> {
            item.setOrder(orderSavedToDB);
            //System.out.println("before save item: " + item);
       });
       this.orderLineRepository.saveAll(orderSavedToDB.getItems());       
       return orderSavedToDB;
    } 
    
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
}
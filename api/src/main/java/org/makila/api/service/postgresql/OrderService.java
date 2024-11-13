package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.repository.postgresql.OrderLineRepository;
import org.makila.api.repository.postgresql.OrderRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    private OrderLineRepository orderLineRepository;

    
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

    public Order saveOrder(Order order) {
        order = orderRepository.save(order);
        Order finalOrder = order;
        order.getItems().forEach(item -> {
           item.setOrder(finalOrder);
           orderLineRepository.save(item);
       });
       return order;
    } 
    
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
}
package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.repository.postgresql.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    
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
}
package org.makila.api.service.mongodb;

import org.makila.api.model.mongodb.OrdersEntity;
import org.makila.api.repository.mongodb.OrdersRepositoryMdb;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;

@Service
@RequiredArgsConstructor
public class OrderServiceMdb {
    private final OrdersRepositoryMdb orderRepository;

    public List<OrdersEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrdersEntity getOrderById(Integer id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // public List<OrdersEntity> getOrdersBetweenOrderDates(LocalDateTime minDate, LocalDateTime maxDate) {
    //     return orderRepository.findOrdersBetweenOrderDates(minDate, maxDate);
    // }

    public OrdersEntity saveOrder(OrdersEntity order) {
       order.setId(Integer.sum(orderRepository.findMaxId().intValue(), 1));
       order = orderRepository.save(order);
       return order;
    } 

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.model.postgresql.OrderLine;
import org.makila.api.repository.postgresql.CustomerRepository;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

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
    
    public List<Order> getOrdersBetweenOrderDates(LocalDateTime minDate, LocalDateTime maxDate) {
        return orderRepository.findOrdersBetweenOrderDates(minDate, maxDate);
    }

/*     @Transactional
    public Order saveOrder(Order order) {
        System.out.println("before save Order: " + order);
        List<OrderLine> items = new LinkedList<OrderLine>();
        Iterator<OrderLine> it = order.getItems().iterator();
        while(it.hasNext()){
            items.add(it.next()); 
        }
        order.setItems(new HashSet<OrderLine>());
        System.out.println("before save Order: " + order);
        System.out.println("before save Order items: " + items);
        final Order newOrder = this.orderRepository.save(order); 
        System.out.println("after save Order: " + newOrder);
        for(OrderLine item: items) {
            item.setOrder(newOrder);
            System.out.println("after adding Order: " + item);        
            items.add(item);
        }
        System.out.println("before save OrderLines: " + items);
         
        if(!items.isEmpty())
            this.orderLineRepository.saveAll(items);

        return newOrder;

    } 
  */  

    public Order saveOrder(Order order) {
        System.out.println("before save Order: " + order);
        return this.orderRepository.save(order); 
    } 

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
}
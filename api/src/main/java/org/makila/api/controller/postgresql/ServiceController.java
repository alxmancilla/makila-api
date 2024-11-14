package org.makila.api.controller.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.model.postgresql.OrderLine;
import org.makila.api.service.postgresql.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;


@RestController
@RequestMapping("/api/pg/")
@RequiredArgsConstructor
public class ServiceController {
    private final OrderService orderService;
    
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    
    @PostMapping("/orders/")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order newOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully");
    }

}
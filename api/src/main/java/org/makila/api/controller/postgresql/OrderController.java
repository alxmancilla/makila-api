package org.makila.api.controller.postgresql;

import org.makila.api.model.postgresql.Order;
import org.makila.api.service.postgresql.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    
    @GetMapping("/dates/")
    public ResponseEntity<List<Order>> getOrdersBetweeOrderDates(@RequestParam(value = "minDate", defaultValue = "2004-01-01") String minD,@RequestParam(value = "maxDate", defaultValue = "2004-01-01") String maxD ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDateTime minDate = LocalDate.parse(minD, formatter).atStartOfDay(); 
        LocalDateTime maxDate = LocalDate.parse(maxD, formatter).atStartOfDay(); 
         
        return ResponseEntity.ok(orderService.getOrdersBetweenOrderDates(minDate, maxDate));
    }
}
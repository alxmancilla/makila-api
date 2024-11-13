package org.makila.api.controller.mongodb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.bson.types.ObjectId;
import org.makila.api.model.mongodb.OrdersEntity;
import org.makila.api.service.mongodb.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mdb/orders")
@RequiredArgsConstructor
public class OrderControllerMdb {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrdersEntity>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersEntity> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderById(new ObjectId(id)));
    }

    @GetMapping("/btwndates/")
    public ResponseEntity<List<OrdersEntity>> getOrdersBetweeOrderDates(@RequestParam(value = "minDate", defaultValue = "2004-01-01") String minD,@RequestParam(value = "maxDate", defaultValue = "2004-01-01") String maxD ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDateTime minDate = LocalDate.parse(minD, formatter).atStartOfDay(); 
        LocalDateTime maxDate = LocalDate.parse(maxD, formatter).atStartOfDay(); 
         
        return ResponseEntity.ok(orderService.getOrdersBetweenOrderDates(minDate, maxDate));
    }

    @PostMapping("/order")
    public ResponseEntity<OrdersEntity> saveProduct(@RequestBody OrdersEntity order) {
        OrdersEntity newOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(new ObjectId(id));
        return ResponseEntity.ok("Order deleted successfully");
    }
}

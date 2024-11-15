package org.makila.api.controller.postgresql;

import java.util.List;

import org.makila.api.model.postgresql.Customer;
import org.makila.api.service.mongodb.OrderServiceMdb;
import org.makila.api.service.postgresql.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }  

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
    return ResponseEntity.ok(customerService.getAllCustomers());
    }
}




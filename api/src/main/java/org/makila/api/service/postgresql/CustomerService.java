package org.makila.api.service.postgresql;

import java.util.List;

import org.makila.api.model.postgresql.Customer;
import org.makila.api.repository.postgresql.CustomerRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

   /*
   public List<Customer> getDeliveryInfoWithState(String state) {
        return customerRepository.findDeliveryInfoWithState(state);
    }
    */ 
}
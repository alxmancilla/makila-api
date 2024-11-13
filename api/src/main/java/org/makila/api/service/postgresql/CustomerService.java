package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Customer;
import org.makila.api.repository.postgresql.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getDeliveryInfoWithState(String state) {
        return customerRepository.findDeliveryInfoWithState(state);
    }
}

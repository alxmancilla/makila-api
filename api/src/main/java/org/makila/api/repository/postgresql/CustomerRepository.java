package org.makila.api.repository.postgresql;

import java.util.List;

import org.makila.api.model.postgresql.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long> {
    //@Query("SELECT c FROM Customer c WHERE json_extract(c.deliveryInfo, '$.address.state') = :state")
    //List<Customer> findDeliveryInfoWithState(String state);
}

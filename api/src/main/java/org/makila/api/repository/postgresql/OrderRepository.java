package org.makila.api.repository.postgresql;

import org.makila.api.model.postgresql.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> { 

    @Query("SELECT o FROM Order o WHERE o.orderDate >= :minDate or o.orderDate <= :maxDate")
    List<Order> findOrdersBetweenOrderDates(LocalDateTime minDate, LocalDateTime maxDate);
   
}
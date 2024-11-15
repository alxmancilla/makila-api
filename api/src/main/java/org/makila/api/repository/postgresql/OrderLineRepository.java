package org.makila.api.repository.postgresql;

import org.makila.api.model.postgresql.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> { 
   
}
package org.makila.api.service.mongodb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class OrderService {
    @PersistenceContext
    private EntityManager entityManager;

    public int getMaxOrderID() {
        Query query = entityManager.createQuery("SELECT MAX(orderid) FROM Order o");
        Long count = (Long) query.getSingleResult();
        return count.intValue();
    }

    
}

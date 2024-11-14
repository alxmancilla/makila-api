package org.makila.api.service.mongodb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class OrderService {
    @PersistenceContext
    private EntityManager entityManager;

    public int getMaxOrderID() {
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u");
        Long count = (Long) query.getSingleResult();
        return count.intValue();
    }

    
}

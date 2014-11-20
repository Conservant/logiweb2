package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
@Repository
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("Order.getAll", Order.class).getResultList();
    }

    @Override
    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order getById(Integer id) {
        Query q = entityManager.createNamedQuery("Order.getById", Order.class);
        q.setParameter("id", id);
        List<Order> list = q.getResultList();
        if (list.isEmpty()) return null;
        return list.get(0);
    }
}

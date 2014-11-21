package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.enums.OrderStatus;
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
    private EntityManager entityManager;

    @Override
    public List<Order> findAll() {
        return entityManager.createNamedQuery("Order.getAll", Order.class).getResultList();
    }

    @Override
    public Order save(Order order) {
        entityManager.persist(order);
        return order;
    }

    @Override
    public Order getById(Long id) {
        Query q = entityManager.createNamedQuery("Order.getById", Order.class);
        q.setParameter("id", id);
        List<Order> list = q.getResultList();
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
        Query q = entityManager.createNamedQuery("Order.getByStatus", Order.class);
        q.setParameter("orderStatus", orderStatus);
        return q.getResultList();
    }
}

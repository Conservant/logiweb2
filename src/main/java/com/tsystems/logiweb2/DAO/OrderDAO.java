package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.enums.OrderStatus;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface OrderDAO {
    List<Order> findAll();
    Order save(Order order);
    Order getById(Long Id);
    List<Order> getOrdersByStatus(OrderStatus orderStatus);
}

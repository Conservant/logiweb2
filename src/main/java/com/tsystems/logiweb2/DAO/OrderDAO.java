package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Order;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface OrderDAO {
    List<Order> findAll();
    Order save(Order order);
    Order getByNumber(Integer number);

}

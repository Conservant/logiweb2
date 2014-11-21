package com.tsystems.logiweb2.Services;


import com.tsystems.logiweb2.model.Order;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface OrderService {
    List<Order> getAll();
    List<Order> getPerformed();
    List<Order> getCreated();
    List<Order> getConfirmed();

    Order createOrder();
    Order closeOrder(Long id);

}

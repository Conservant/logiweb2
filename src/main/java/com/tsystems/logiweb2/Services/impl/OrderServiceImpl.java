package com.tsystems.logiweb2.Services.impl;

import com.tsystems.logiweb2.DAO.OrderDAO;
import com.tsystems.logiweb2.Services.OrderService;
import com.tsystems.logiweb2.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public List<Order> getAll() {
        return orderDAO.findAll();
    }

    @Override
    public Order save(Order order) {
        if (orderDAO.getById(order.getId()) == null) {
            return orderDAO.save(order);
        }
        return null;
    }
}

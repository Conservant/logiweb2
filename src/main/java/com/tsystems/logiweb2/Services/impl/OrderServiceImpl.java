package com.tsystems.logiweb2.Services.impl;

import com.tsystems.logiweb2.DAO.OrderDAO;
import com.tsystems.logiweb2.Services.OrderService;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.enums.OrderStatus;
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
    public Order createOrder() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        return orderDAO.save(order);
    }

    @Override
    public List<Order> getCreated() {
        return orderDAO.getOrdersByStatus(OrderStatus.CREATED);
    }

    @Override
    public List<Order> getConfirmed() {
        return orderDAO.getOrdersByStatus(OrderStatus.CONFIRMED);
    }

    @Override
    public List<Order> getPerformed() {
        return orderDAO.getOrdersByStatus(OrderStatus.PERFORMED);
    }

    @Override
    public Order closeOrder(Long id) {
        Order order = orderDAO.getById(id);
        order.setOrderStatus(OrderStatus.CLOSED);
        return orderDAO.save(order);
    }
}

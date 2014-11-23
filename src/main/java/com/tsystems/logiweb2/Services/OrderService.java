package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order createOrder() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Transactional
    public Order findOrderWithItems(Long id) {
        Order order = findById(id);
        List<OrderItem> items = orderItemRepository.findByOrder(order);
        order.setItems(items);
        return order;
    }
/*
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
    }*/
}

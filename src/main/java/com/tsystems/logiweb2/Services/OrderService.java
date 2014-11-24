package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;
import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.Repository.TruckRepository;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.Truck;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private TruckRepository truckRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private DriverRepository driverRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
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

    public void save(Order order) {
        order.setOrderStatus(OrderStatus.CREATED);
        orderRepository.save(order);
    }

    public void changeStatus(Long id, OrderStatus status) {
        Order order = findById(id);
        order.setOrderStatus(status);
    }

    public void attachTruck(String regNumber, Long id) {
        Truck truck = truckRepository.findByRegNumber(regNumber);
        if (truck.getOrder() != null) {

        }
        Order order = orderRepository.findOne(id);
        order.setTruck(truck);
        orderRepository.save(order);
    }

    public void attachDrivers(List<String> licNumbers, Long id) {
        List<Driver> drivers = new ArrayList<>();
        for (String number: licNumbers) {
            drivers.add(driverRepository.findByLicNumber(number));
        }

        Driver driver = driverRepository.findByLicNumber(licNumber);
        if (driver.getDriverStatus() != DriverStatus.FREE) {

        }
        Truck truck = truckRepository.findOne(id);
        driver.setTruck(truck);
        driverRepository.save(driver);
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

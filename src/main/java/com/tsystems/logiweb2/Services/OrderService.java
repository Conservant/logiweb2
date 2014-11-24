package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;
import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.Repository.TruckRepository;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.Truck;
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

    public void save() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        orderRepository.save(order);
    }

    public void closeOrder(Long id) {
        Order order = findById(id);
        if (order.getOrderStatus() == OrderStatus.PERFORMED) {
            order.setOrderStatus(OrderStatus.CLOSED);
            Truck truck = truckRepository.findByRegNumber(order.getTruck().getRegNumber());
            List<Driver> drivers = driverRepository.findByTruck(truck);
            for(Driver dr: drivers) {
                dr.setTruck(null);
                driverRepository.save(dr);
            }
            order.setTruck(null);
            orderRepository.save(order);
        }
    }

    public void confirmOrder(Long id) {
        Order order = orderRepository.getOne(id);
        if (order.getItems().isEmpty()) {

        }

        order.setOrderStatus(OrderStatus.CONFIRMED);
    }

    public void attachTruck(Long id, String regNumber) {

        Truck truck = truckRepository.findByRegNumber(regNumber);

        if (truck.getOrder() != null) {
            System.out.println("фура занята");
            return;
        }

        Order order = orderRepository.findOne(id);
        order.setTruck(truck);
        orderRepository.save(order);
    }

    public void attachDrivers(Long id) {
        id = 3l;
        System.out.println(id);
    }
}

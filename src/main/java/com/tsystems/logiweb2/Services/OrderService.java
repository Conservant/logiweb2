package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;
import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.Repository.TruckRepository;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.Truck;
import com.tsystems.logiweb2.model.enums.Delivery;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Class of service layer for working with orders.
 * Provides layer operations.
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

    @Transactional
    public boolean confirmOrder(Long id) {
        Order order = orderRepository.getOne(id);
        if (order.getItems().isEmpty()) {
            return false;
        }
        order.setOrderStatus(OrderStatus.CONFIRMED);
        return true;
    }

    public String attachTruck(Long id, String regNumber) {

        Truck truck = truckRepository.findByRegNumber(regNumber);
        if (truck == null) {
            return "" + id + "/attachTruck.html?isFound=false";
        }

        if (truck.getOrder() != null) {
            return "" + id + "/attachTruck.html?isBusy=true";
        }

        Order order = orderRepository.findOne(id);

        double totalWeight = 0;
        List<OrderItem> items = order.getItems();
        for (OrderItem item: items) {
            totalWeight += item.getWeight();
        }

        if (truck.getCapacity() < totalWeight) {
            return "" + id + "/attachTruck.html?notEnoughtCapacity=true";
        }

        order.setTruck(truck);
        orderRepository.save(order);
        return "" + id + ".html?isTruckAttached=true";
    }

    public String attachDriver(Long id, String licenseNumber) {
        Driver driver = driverRepository.findByLicenseNumber(licenseNumber);
        if (driver == null) {
            return "" + id + "/attachDriver.html?isFound=false";
        }

        if (driver.getTruck() != null) {
            return "" + id + "/attachDriver.html?isBusy=true";
        }
        Order order = orderRepository.findOne(id);
        Truck truck = order.getTruck();
        driver.setTruck(truck);
        driver.setDriverStatus(DriverStatus.ON_ROUTE);
        driverRepository.save(driver);

        if (truck.getRequiredNumberOfDrivers() == truck.getDrivers().size() + 1) {
            order.setOrderStatus(OrderStatus.SHIPPED);
            orderRepository.save(order);
            return "" + id + ".html?isComplete=true";
        }

        return "" + id + ".html?isDriverAttached=true";
    }

    public void closeOrder(Long id) {
        Order order = findById(id);
        if (order.getOrderStatus() == OrderStatus.PERFORMED) {
            order.setOrderStatus(OrderStatus.CLOSED);
            Truck truck = truckRepository.findByRegNumber(order.getTruck().getRegNumber());
            List<Driver> drivers = driverRepository.findByTruck(truck);
            for(Driver dr: drivers) {
                dr.setTruck(null);
                dr.setDriverStatus(DriverStatus.FREE);
                driverRepository.save(dr);
            }
            truck.setDrivers(new ArrayList<Driver>());
            truckRepository.save(truck);

            order.setTruck(null);
            orderRepository.save(order);
        }
    }

    public List<Driver> findDriversByOrder(Long id) {
        List<Driver> resultList = new ArrayList<>();
        Order order = orderRepository.findOne(id);
        Truck truck = order.getTruck();
        if (truck == null) {
            return resultList;
        }
        resultList = driverRepository.findByTruck(truck);
        return resultList;
    }

    public String attachItem(Long id, OrderItem orderItem) {
        Order order = orderRepository.getOne(id);
        orderItem.setDelivery(Delivery.NOT_DELIVERED);
        orderItem.setOrder(order);
        orderItem.setId(null);
        orderItemRepository.save(orderItem);
        return "" + id + ".html?isItemAttached=true";
    }
}
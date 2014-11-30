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

    /**
     * Method retrieves list of all orders
     * @return list of orders
     */
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    /**
     * Method retrieves order from database looking for id
     * @param id id of order
     * @return Entity object order
     */
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

    /**
     * Method creates new order in database
     */
    @Transactional
    public void save() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        orderRepository.save(order);
    }

    /**
     * changes status of order to CONFIRMED
     * @param id id of order
     * @return true if order was CONFIRMED
     *          false if order is empty
     */
    @Transactional
    public boolean confirmOrder(Long id) {
        Order order = orderRepository.getOne(id);
        if (order.getItems().isEmpty()) {
            return false;
        }
        order.setOrderStatus(OrderStatus.CONFIRMED);
        return true;
    }

    /**
     * Method looking for truck by registration number
     * then attaches this truck to order
     * @param id id of order
     * @param regNumber regNumber of truck
     * @return empty string if truck was attached
     * or special message
     */
    @Transactional
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

    /**
     * Method looking for driver by license number
     * then attaches this driver to order
     * @param id id of order
     * @param licenseNumber license number of driver
     * @return success message
     * or special message
     */
    @Transactional
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

    /**
     * Method change status of order to closed
     * order must be performed
     * @param id id of order
     */
    @Transactional
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

    /**
     * Method retrieves list of drivers from one orders
     * @param id id of order
     * @return list of drivers
     */
    @Transactional
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

    /**
     * Method adds item to order
     * @param id id of order
     * @param orderItem item to adding
     * @return message of status
     */
    @Transactional
    public String attachItem(Long id, OrderItem orderItem) {
        Order order = orderRepository.getOne(id);
        orderItem.setDelivery(Delivery.NOT_DELIVERED);
        orderItem.setOrder(order);
        orderItem.setId(null);
        orderItemRepository.save(orderItem);
        return "" + id + ".html?isItemAttached=true";
    }
}
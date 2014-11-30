package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;
import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.Repository.UserRepository;
import com.tsystems.logiweb2.model.*;
import com.tsystems.logiweb2.model.enums.Delivery;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import com.tsystems.logiweb2.model.enums.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class of service layer for working with drivers.
 * Provides layer operations.
 */
@Service
@Transactional
public class DriverService {

    private static Logger logger = Logger.getLogger(DriverService.class);


    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    /**
     * Method adds new driver to database.
     *
     * @param driver entity object to adding
     */
    @Transactional
    public void save(Driver driver) {
        logger.info("Service method 'save' for driver called with argument " + driver);
        driver.setDriverStatus(DriverStatus.FREE);
        driverRepository.save(driver);

        User user = new User();
        user.setLogin(driver.getLicenseNumber());
        user.setPassword(driver.getLicenseNumber());
        user.setRole(Role.ROLE_DRIVER);
        userRepository.save(user);
    }

    /**
     * Method gets list of all drivers from database
     *
     * @return list of all drivers
     */
    @Transactional
    public List<Driver> getAll() {
        logger.info("Service  method 'get All' for drivers called");
        return driverRepository.findAll();
    }

    /**
     * Method returns single Driver from database
     * searching by a license
     * @param licenseNumber license number of driver
     * @return Entity object Driver
     */
    @Transactional
    public Driver findDriver(String licenseNumber) {
        return driverRepository.findByLicenseNumber(licenseNumber);
    }

    /**
     * Method returns Truck which is driven by driver with
     * given license number
     * @param licenseNumber license number of driver
     * @return Entity object Truck
     */
    public Truck findTruck(String licenseNumber) {
        Driver driver = driverRepository.findByLicenseNumber(licenseNumber);
        return driver.getTruck();
    }


    /**
     * Method returns Order which is executing by driver with
     * given license number
     * @param licenseNumber license number of driver
     * @return Entity object Order
     */
    @Transactional
    public Order findOrder(String licenseNumber) {
        Driver driver = driverRepository.findByLicenseNumber(licenseNumber);
        Truck truck = driver.getTruck();

        if (truck == null) {
            return null;
        }

        return orderRepository.findByTruck(truck);
    }

    /**
     * Method returns list of co-drivers which is executing by driver with
     * given license number
     * @param licenseNumber
     * @return
     */
    @Transactional
    public List<Driver> getDriversFromOrder(String licenseNumber) {
        Truck truck = findTruck(licenseNumber);
        return driverRepository.findByTruck(truck);
    }


    /**
     * Method changes status of driver to given.
     * @param licenseNumber license number of driver
     * @param status
     * @return empty string if ok, and another driver message in other case
     */
    @Transactional
    public String changeStatus(String licenseNumber, DriverStatus status) {
        Driver driver = findDriver(licenseNumber);
        if (driver.getDriverStatus() == DriverStatus.FREE) {
            return "";
        }
        if (status == DriverStatus.ON_ROUTE) {
            driver.setDriverStatus(status);
            driverRepository.save(driver);
            return "";
        }

        List<Driver> sameDrivers = getDriversFromOrder(licenseNumber);
        for (Driver dr : sameDrivers) {
            if (dr.getDriverStatus() == DriverStatus.DRIVING) {
                return "?anotherDriverIsDriving=true";
            }
        }
        driver.setDriverStatus(status);
        driverRepository.save(driver);
        return "";
    }

    /**
     *  Method changes status of cargo to DELIVERED
     *  and changes status of Order if all cargos are delivered
     * @param id id of of OrderItem
     */
    @Transactional
    public void deliver(Long id) {
        OrderItem item = orderItemRepository.findOne(id);
        item.setDelivery(Delivery.DELIVERED);
        orderItemRepository.save(item);
        Order order = item.getOrder();

        List<OrderItem> items = orderItemRepository.findByOrder(order);
        for (OrderItem it: items) {
            if (it.getDelivery() == Delivery.NOT_DELIVERED) {
                return;
            }
        }

        order.setOrderStatus(OrderStatus.PERFORMED);
    }
}

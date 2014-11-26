package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.Truck;
import com.tsystems.logiweb2.model.enums.DriverStatus;
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

    /**
     * Method adds new driver to database.
     *
     * @param driver entity object to adding
     */
    public void save(Driver driver) {
        logger.info("Service method 'save' for driver called with argument " + driver);
        driver.setDriverStatus(DriverStatus.FREE);
        driverRepository.save(driver);
    }

    /**
     * Method gets list of all drivers from database
     *
     * @return list of all drivers
     */
    public List<Driver> getAll() {
        logger.info("Service  method 'get All' for drivers called");
        return driverRepository.findAll();
    }

    public Driver findDriver(String licenseNumber) {
        return driverRepository.findByLicenseNumber(licenseNumber);
    }

    public Truck findTruck(String licenseNumber) {
        Driver driver = driverRepository.findByLicenseNumber(licenseNumber);
        return driver.getTruck();
    }

    public Order findOrder(String licenseNumber) {
        Driver driver = driverRepository.findByLicenseNumber(licenseNumber);
        Truck truck = driver.getTruck();

        if (truck == null) {
            return null;
        }

        return orderRepository.findByTruck(truck);
    }

    public List<Driver> getDriversFromOrder(String licenseNumber) {
        Truck truck = findTruck(licenseNumber);
        return driverRepository.findByTruck(truck);
    }

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
}

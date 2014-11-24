package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;

import com.tsystems.logiweb2.model.Driver;
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

    Logger logger = Logger.getLogger(DriverService.class);


    @Autowired
    private DriverRepository driverRepository;

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

    public List<Driver> getFreeDrivers() {
        return driverRepository.findByDriverStatus(DriverStatus.FREE);
    }
}

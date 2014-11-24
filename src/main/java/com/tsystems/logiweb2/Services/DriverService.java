package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by StarKiller on 17.11.2014.
 */
@Service
@Transactional
public class DriverService {

    Logger logger = Logger.getLogger(DriverService.class);


    @Autowired
    private DriverRepository driverRerository;


    public void save(Driver driver) {
        logger.info("Service method 'save' for driver called with argument " + driver);
        driver.setDriverStatus(DriverStatus.FREE);
        driverRerository.save(driver);
    }

    public List<Driver> getAll() {
        logger.info("Service  method 'get All' for drivers called");
        List<Driver> drivers = driverRerository.findAll();
        return drivers;
    }

    public List<Driver> getFreeDrivers() {
        return driverRerository.findByDriverStatus(DriverStatus.FREE);
    }

}

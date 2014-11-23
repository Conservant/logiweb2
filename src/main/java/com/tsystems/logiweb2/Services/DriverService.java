package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.DriverRepository;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.enums.DriverStatus;
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


    @Autowired
    private DriverRepository driverRerository;


    public void save(Driver driver) {
        driver.setDriverStatus(DriverStatus.FREE);
        driverRerository.save(driver);
    }

    public List<Driver> getAll() {

        List<Driver> drivers = driverRerository.findAll();

        for (Driver dr: drivers) {
            System.out.println(dr);
        }

        return drivers;

    }
}

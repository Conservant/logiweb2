package com.tsystems.logiweb2.Services.impl;

import com.tsystems.logiweb2.DAO.DriverDAO;

import com.tsystems.logiweb2.Services.DriverService;
import com.tsystems.logiweb2.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by StarKiller on 17.11.2014.
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {


    @Autowired
    private DriverDAO driverDAO;


    @Override
    public Driver save(Driver driver) {

        if (driverDAO.findByLicNumber(driver.getLicNumber()) == null) {
            return driverDAO.save(driver);
        }
        System.out.println("Driver not added");
        return driver;
    }

    @Override
    public List<Driver> getAll() {

        List<Driver> drivers = driverDAO.findAll();

        for (Driver dr: drivers) {
            System.out.println(dr);
        }

        return drivers;

    }
}

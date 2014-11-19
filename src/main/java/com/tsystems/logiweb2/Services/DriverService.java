package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.model.Driver;

import java.util.List;

/**
 * Created by StarKiller on 17.11.2014.
 */
public interface DriverService {
    Driver save(Driver driver);
    List<Driver> getAll();
    Driver findByLicNumber(String licNumber);
}

package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Driver;

import java.util.List;

/**
 * Created by StarKiller on 19.11.2014.
 */
public interface DriverDAO {
    List<Driver> findAll();
    Driver save(Driver driver);
}

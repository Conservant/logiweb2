package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Truck;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface TruckDAO {
    List<Truck> findAll();
    Truck save(Truck truck);
}

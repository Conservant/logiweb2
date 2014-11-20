package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.model.Truck;

import java.util.List;

/**
 * Created by StarKiller on 17.11.2014.
 */
public interface TruckService {
    Truck save(Truck truck);
    List<Truck> getAll();
}

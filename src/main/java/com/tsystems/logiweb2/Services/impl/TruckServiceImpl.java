package com.tsystems.logiweb2.Services.impl;

import com.tsystems.logiweb2.DAO.TruckDAO;
import com.tsystems.logiweb2.Services.TruckService;
import com.tsystems.logiweb2.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by StarKiller on 17.11.2014.
 */
@Service
@Transactional
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckDAO truckDAO;

    @Override
    public Truck newTruck(Truck truck) {
        return truckDAO.save(truck);
    }

    @Override
    public List<Truck> allTrucks() {
        return truckDAO.findAll();
    }

    @Override
    public Truck getByRegNumber(String regNubmer) {
        return null;
    }

    @Override
    public Truck update(Truck truck) {
        return null;
    }
}

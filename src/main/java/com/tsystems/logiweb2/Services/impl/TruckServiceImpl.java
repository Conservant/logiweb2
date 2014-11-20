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
    public Truck save(Truck truck) {
        if (truckDAO.findByRegNumber(truck.getRegNumber()) == null) {
            return truckDAO.save(truck);
        }
        return truck;
    }

    @Override
    public List<Truck> getAll() {
        return truckDAO.findAll();
    }

}

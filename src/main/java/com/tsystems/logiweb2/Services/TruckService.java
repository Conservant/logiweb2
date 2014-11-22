package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.TruckRepository;
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
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

    public Truck save(Truck truck) {
        return truckRepository.save(truck);
    }

    public List<Truck> getAll() {
        return truckRepository.findAll();
    }

}

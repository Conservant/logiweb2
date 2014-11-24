package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.TruckRepository;
import com.tsystems.logiweb2.model.Truck;
import com.tsystems.logiweb2.model.enums.CapacityClass;
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
public class TruckService {

    Logger logger = Logger.getLogger(TruckService.class);

    @Autowired
    private TruckRepository truckRepository;

    public void save(Truck truck) {
        logger.info("Service method 'save' for new truck called with argument" + truck);
        Double cap = truck.getCapacity();
        if (cap < 1) {
            truck.setCapacityClass(CapacityClass.SMALL);
        } else if (cap < 5) {
            truck.setCapacityClass(CapacityClass.MEDIUM);
        } else {
            truck.setCapacityClass(CapacityClass.LARGE);
        }
        truckRepository.save(truck);
    }

    public List<Truck> getAll() {
        logger.info("Service method 'getAll' for trucks called");
        return truckRepository.findAll();
    }

}

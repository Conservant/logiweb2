package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Truck;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
@Repository
public class TruckDAOImpl implements TruckDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Truck> findAll() {
        List<Truck> trucks = entityManager.createNamedQuery("Truck.allTrucks", Truck.class).getResultList();
        return trucks;
    }

    @Override
    public Truck save(Truck truck) {
        entityManager.persist(truck);
        return truck;
    }
}

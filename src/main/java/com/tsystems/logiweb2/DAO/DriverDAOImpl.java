package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Driver;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by StarKiller on 19.11.2014.
 */

@Repository
public class DriverDAOImpl implements DriverDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Driver> findAll() {
        List<Driver> drivers = entityManager.createNamedQuery("Driver.allDrivers", Driver.class).getResultList();
        return drivers;
    }

    @Override
    public Driver save(Driver driver) {
        entityManager.persist(driver);
        return driver;
    }
}

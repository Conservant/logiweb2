package com.tsystems.logiweb2.DAO;

import com.tsystems.logiweb2.model.Driver;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
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
        List<Driver> drivers = entityManager.createNamedQuery("Driver.findAll", Driver.class).getResultList();
        return drivers;
    }

    @Override
    public Driver save(Driver driver)  throws PersistenceException {
        entityManager.persist(driver);
        return driver;
    }

    @Override
    public Driver findByLicNumber(String licNumber) {
        System.out.println("Called licnumber check");
        Query q = entityManager.createNamedQuery("Driver.getByLicNumber", Driver.class);
        q.setParameter("licNumber", licNumber);
        List<Driver> list = q.getResultList();
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}

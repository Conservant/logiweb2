package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by StarKiller on 19.11.2014.
 */
public interface DriverRepository extends JpaRepository<Driver, Long>{
    Driver findByLicNumber(String s);
}

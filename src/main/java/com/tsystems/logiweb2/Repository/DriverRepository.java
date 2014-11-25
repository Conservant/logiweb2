package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Driver;
import com.tsystems.logiweb2.model.Truck;
import com.tsystems.logiweb2.model.enums.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Class provided CRUD-operations for Driver entity
 * Operations implements by Spring Data JPA
 */
public interface DriverRepository extends JpaRepository<Driver, Long>{
    Driver findByLicenseNumber(String s);
    List<Driver> findByDriverStatus(DriverStatus status);
    List<Driver> findByTruck(Truck truck);
}

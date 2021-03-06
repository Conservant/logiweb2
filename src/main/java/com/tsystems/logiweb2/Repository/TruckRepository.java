package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class provided CRUD-operations for Truck entity
 * Operations implements by Spring Data JPA
 */
public interface TruckRepository extends JpaRepository<Truck, Long>{
    Truck findByRegNumber(String s);
}

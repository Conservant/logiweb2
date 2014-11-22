package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface TruckRepository extends JpaRepository<Truck, Long>{
}

package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Class provided CRUD-operations for Order entity
 * Operations implements by Spring Data JPA
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByTruck(Truck truck);
}

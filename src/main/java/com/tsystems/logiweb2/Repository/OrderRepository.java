package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.Truck;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Class provided CRUD-operations for Order entity
 * Operations implements by Spring Data JPA
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderStatus(OrderStatus status);
    Order findByTruck(Truck truck);
}

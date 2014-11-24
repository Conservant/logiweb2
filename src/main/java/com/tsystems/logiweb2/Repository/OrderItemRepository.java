package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Class provided CRUD-operations for OrderItem entity
 * Operations implements by Spring Data JPA
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
}

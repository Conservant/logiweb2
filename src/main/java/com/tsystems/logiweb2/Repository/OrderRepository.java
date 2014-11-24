package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderStatus(OrderStatus status);
}

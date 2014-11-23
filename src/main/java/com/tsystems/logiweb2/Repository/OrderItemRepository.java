package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by StarKiller on 23.11.2014.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
}

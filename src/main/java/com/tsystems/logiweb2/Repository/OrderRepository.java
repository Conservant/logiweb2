package com.tsystems.logiweb2.Repository;

import com.tsystems.logiweb2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by StarKiller on 20.11.2014.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}

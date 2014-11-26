package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.enums.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by StarKiller on 23.11.2014.
 */
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void save(OrderItem item, Long idOrder) {
        Order order = orderRepository.findOne(idOrder);
        item.setOrder(order);
        item.setDelivery(Delivery.NOT_DELIVERED);
        orderItemRepository.save(item);
    }
}

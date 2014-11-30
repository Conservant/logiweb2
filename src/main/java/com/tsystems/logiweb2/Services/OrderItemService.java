package com.tsystems.logiweb2.Services;

import com.tsystems.logiweb2.Repository.OrderItemRepository;
import com.tsystems.logiweb2.Repository.OrderRepository;
import com.tsystems.logiweb2.model.Order;
import com.tsystems.logiweb2.model.OrderItem;
import com.tsystems.logiweb2.model.enums.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class of service layer for working with items of orders.
 * Provides layer operations.
 */
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Method adds item to order and saves it in database
     * @param item item to save
     * @param idOrder id of Order to attach
     */
    @Transactional
    public void save(OrderItem item, Long idOrder) {
        Order order = orderRepository.findOne(idOrder);
        item.setOrder(order);
        item.setDelivery(Delivery.NOT_DELIVERED);
        orderItemRepository.save(item);
    }

    @Transactional
    public void save(OrderItem item) {
        orderItemRepository.save(item);
    }
}

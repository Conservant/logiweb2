package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.model.enums.OrderStatus;

/**
 * Entity Order class
 */
public class Order {
    private Integer id;
    private Integer uniqueNumber;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(Integer uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}

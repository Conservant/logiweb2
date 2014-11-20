package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.model.enums.OrderStatus;

import javax.persistence.*;

/**
 * Entity Order class
 */
@Entity
@Table(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name = "Order.getAll", query = "SELECT o FROM Order o"),
        @NamedQuery(name = "Order.getByNumber", query = "SELECT o FROM Order o WHERE o.number = :number")
})

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}

package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;

/**
 * Entity Order class
 */
@Entity
@Table(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name = "Order.getAll", query = "SELECT o FROM Order o"),
        @NamedQuery(name = "Order.getByNumber", query = "SELECT o FROM Order o WHERE o.id = :id"),
        @NamedQuery(name = "Order.getByStatus", query = "SELECT o FROM Order o WHERE o.orderStatus = :orderStatus")
})

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> items;

    public Order() {
        orderStatus = OrderStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}

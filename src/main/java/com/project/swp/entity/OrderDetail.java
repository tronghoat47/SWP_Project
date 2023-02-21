package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "OrderID")
//    private int orderID;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FoodID", referencedColumnName = "FoodID")
    private Menu menu;

    public OrderDetail() {
    }

    public OrderDetail( Order order, Menu menu, int quantity) {
//        this.orderID = orderID;
        this.order = order;
        this.menu = menu;
        this.quantity = quantity;
    }

    @Column(name = "Quantity")
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

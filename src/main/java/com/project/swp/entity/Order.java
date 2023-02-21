package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CusID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmpID")
    private Staff staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TableID")
    private Tableq table;

    @Column(name = "Total")
    private Double total;

    @Column(name = "TimeOrder")
    private String timeOrder;

    @Column(name = "TimeCancel")
    private String timeCancel;

    @Column(name = "MethodPayment")
    private String methodPayment;


    // Constructor
    public Order() {
    }

    public Order(int orderId, Customer customer, Staff staff, Restaurant restaurant, Tableq table, Double total, String timeOrder, String timeCancel, String methodPayment) {
        this.orderId = orderId;
        this.customer = customer;
        this.staff = staff;
        this.restaurant = restaurant;
        this.table = table;
        this.total = total;
        this.timeOrder = timeOrder;
        this.timeCancel = timeCancel;
        this.methodPayment = methodPayment;
    }


    //Get set
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Tableq getTable() {
        return table;
    }

    public void setTable(Tableq table) {
        this.table = table;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getTimeCancel() {
        return timeCancel;
    }

    public void setTimeCancel(String timeCancel) {
        this.timeCancel = timeCancel;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }
}




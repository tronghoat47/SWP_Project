package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Order order;

    public Invoice() {
    }

    public Invoice(Order order, Menu menu, int actualQuantity, float discount, int actualTotal, Staff staff, String timePay) {
        this.order = order;
        this.menu = menu;
        this.actualQuantity = actualQuantity;
        this.discount = discount;
        this.actualTotal = actualTotal;
        this.staff = staff;
        this.timePay = timePay;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FoodID", referencedColumnName = "FoodID")
    private Menu menu;

    @Column(name = "ActualQuantity")
    private int actualQuantity;

    @Column(name = "Discount")
    private float discount;

    @Column(name = "ActualTotal")
    private int actualTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmpID", referencedColumnName = "EmpID")
    private Staff staff;

    @Column(name = "TimePay")
    private String timePay;

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

    public int getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(int actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getActualTotal() {
        return actualTotal;
    }

    public void setActualTotal(int actualTotal) {
        this.actualTotal = actualTotal;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getTimePay() {
        return timePay;
    }

    public void setTimePay(String timePay) {
        this.timePay = timePay;
    }
}

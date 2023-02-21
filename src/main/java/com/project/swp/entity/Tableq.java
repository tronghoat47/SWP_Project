package com.project.swp.entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@jakarta.persistence.Table(name = "[Table]")
public class Tableq {

    @Id
    private String tableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("resID")
    @JoinColumn(name = "ResID", referencedColumnName = "ResID")
    private Restaurant restaurant;

    @Column(name = "Type")
    private String type;

    @Column(name = "TimeOrder")
    private String timeOrder;

    @Column(name = "[Description]")
    private String description;

    public Tableq() {
    }

    public Tableq(String tableId, Restaurant restaurant, String type, String timeOrder, String description) {
        this.tableId = tableId;
        this.restaurant = restaurant;
        this.type = type;
        this.timeOrder = timeOrder;
        this.description = description;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
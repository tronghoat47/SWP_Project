package com.project.swp.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
@Entity
@Table(name = "Rate")
public class Rate {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResID", referencedColumnName = "ResID")
    private Restaurant restaurant;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CusID", referencedColumnName = "CusID")
    private Customer customer;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Rating")
    private float rating;


    public Rate() {
    }

    public Rate(Restaurant restaurant, Customer customer, String comment, float rating) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.comment = comment;
        this.rating = rating;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

package com.project.swp.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @Column(name = "FoodID")
    private int foodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

    @Column(name = "FoodName")
    private String foodName;

    @Column(name = "Price")
    private Double price;

    public Menu() {
    }

    public Menu(int foodId, Restaurant restaurant, String foodName, Double price, String picture, boolean statusFood, String descriptionFood, CategoryMenu categoryMenu) {
        this.foodId = foodId;
        this.restaurant = restaurant;
        this.foodName = foodName;
        this.price = price;
        this.picture = picture;
        this.statusFood = statusFood;
        this.descriptionFood = descriptionFood;
        this.categoryMenu = categoryMenu;
    }

    @Column(name = "Picture")
    private String picture;

    @Column(name = "StatusFood")
    private boolean statusFood;

    @Column(name = "DescriptionFood")
    private String descriptionFood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CateID")
    private CategoryMenu categoryMenu;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isStatusFood() {
        return statusFood;
    }

    public void setStatusFood(boolean statusFood) {
        this.statusFood = statusFood;
    }

    public String getDescriptionFood() {
        return descriptionFood;
    }

    public void setDescriptionFood(String descriptionFood) {
        this.descriptionFood = descriptionFood;
    }

    public CategoryMenu getCategoryMenu() {
        return categoryMenu;
    }

    public void setCategoryMenu(CategoryMenu categoryMenu) {
        this.categoryMenu = categoryMenu;
    }
}

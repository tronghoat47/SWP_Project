package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @Column(name = "ResID")
    private int resID;

    @Column(name = "ResName", length = Integer.MAX_VALUE)
    private String resName;

    @Column(name = "City", length = 50)
    private String city;

    @Column(name = "District", length = 50)
    private String district;

    @Column(name = "Commune", length = 50)
    private String commune;

    @Column(name = "Picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "Map", length = Integer.MAX_VALUE)
    private String map;

    @Column(name = "CategoryRes", length = 100)
    private String categoryRes;

    @ManyToOne
    @JoinColumn(name = "CompanyID")
    private Company company;

    public Restaurant() {
    }

    public Restaurant(int resID, String resName, String city, String district, String commune, String picture, String map, String categoryRes, Company company) {
        this.resID = resID;
        this.resName = resName;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.picture = picture;
        this.map = map;
        this.categoryRes = categoryRes;
        this.company = company;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getCategoryRes() {
        return categoryRes;
    }

    public void setCategoryRes(String categoryRes) {
        this.categoryRes = categoryRes;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}

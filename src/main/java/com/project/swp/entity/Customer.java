package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CusID")
    private int cusID;

    @Column(name = "UserNamme")
    private String username;

    @Column(name = "[Password]")
    private String password;

    @Column(name = "CusName")
    private String cusName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    public int getCusID() {
        return cusID;
    }

    public Customer() {
    }

    public Customer(int cusID, String username, String password, String cusName, String phoneNumber, String email) {
        this.cusID = cusID;
        this.username = username;
        this.password = password;
        this.cusName = cusName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

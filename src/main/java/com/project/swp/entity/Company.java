package com.project.swp.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyID")
    private int companyID;

    public Company() {
    }

    public Company(int companyID, String companyName, String password, String hotline, String email, String status) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.password = password;
        this.hotline = hotline;
        this.email = email;
        this.status = status;
    }

    @Column(name = "CompanyName", length = Integer.MAX_VALUE)
    private String companyName;

    @Column(name = "Password", length = 20)
    private String password;

    @Column(name = "Hotline", length = 15)
    private String hotline;

    @Column(name = "Email", length = 30)
    private String email;

    @Column(name = "Status", length = 30)
    private String status;

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

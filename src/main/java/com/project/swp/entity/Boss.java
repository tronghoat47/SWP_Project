package com.project.swp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Boss")
public class Boss {

    @Id
    @Column(name = "Username", length = 30)
    private String username;

    @Column(name = "Password", length = 30)
    private String password;

    public Boss() {
    }

    public Boss(String username, String password) {
        this.username = username;
        this.password = password;
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
}

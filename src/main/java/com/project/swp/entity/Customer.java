package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "CusID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusID;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "[Password]")
    private String password;

    @Column(name = "CusName")
    private String cusName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

}

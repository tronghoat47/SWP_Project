package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "CusID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EmpID")
    private Staff staff;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "TableqId", referencedColumnName="TableqId"),
//            @JoinColumn(name = "ResID", referencedColumnName="ResID")
//    })
//    private Tableq table;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

    @Column(name = "TimeOrder", columnDefinition = "DATETIME")
    private LocalDateTime timeOrder;

    @Column(name = "TimeCancel", columnDefinition = "DATETIME")
    private LocalDateTime timeCancel;

    @Column(name = "MethodPayment")
    private String methodPayment;

    @Column(name = "OrderStatus")
    private String orderStatus;

    @Column(name = "NumberCustomer")
    private int numberCustomer;

    @Column(name = "PhoneCustomer")
    private String phoneCustomer;

    @Column(name = "Total")
    private Double total;

    @Column(name = "StringTable")
    private String stringTable;

}




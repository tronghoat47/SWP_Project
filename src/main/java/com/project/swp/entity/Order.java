package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CusID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EmpID")
    private Staff staff;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ResID")
//    private Tableq tableq;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "TableqId", referencedColumnName="TableqId"),
            @JoinColumn(name = "ResID", referencedColumnName="ResID")
    })
    private Tableq table;

    @Column(name = "TimeOrder")
    private String timeOrder;

    @Column(name = "TimeCancel")
    private String timeCancel;

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

}




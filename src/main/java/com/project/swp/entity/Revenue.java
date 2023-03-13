package com.project.swp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Revenue")
public class Revenue {
    @Id
    @Column(name = "revId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int revId;
    @Column(name = "year")
    private int year;
    @Column(name = "month")
    private int month;
    @Column(name = "revenue")
    private double revenue;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;
}

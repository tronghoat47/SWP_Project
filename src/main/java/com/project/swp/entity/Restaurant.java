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
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @Column(name = "ResID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CompanyID")
    private Company company;

    @Column(name = "RatingPoint")
    private float ratingPoint;

}

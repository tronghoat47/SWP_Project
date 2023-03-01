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
@Table(name = "Menu")
public class Menu {
    @Id
    @Column(name = "FoodID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

    @Column(name = "FoodName")
    private String foodName;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Picture")
    private String picture;

    @Column(name = "StatusFood")
    private boolean statusFood;

    @Column(name = "DescriptionFood")
    private String descriptionFood;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CateID")
    private CategoryMenu categoryMenu;
}

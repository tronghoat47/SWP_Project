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
@Table(name = "CategoryMenu")
public class CategoryMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CateID")
    private int cateID;

    @Column(name = "CateName", length = Integer.MAX_VALUE)
    private String cateName;

    @Column(name = "Description", length = Integer.MAX_VALUE)
    private String description;

}

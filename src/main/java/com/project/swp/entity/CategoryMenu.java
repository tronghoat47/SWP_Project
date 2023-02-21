package com.project.swp.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
@Entity
@Table(name = "CategoryMenu")
public class CategoryMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CateID")
    private int cateID;

    public CategoryMenu() {
    }

    public CategoryMenu(int cateID, String cateName, String description) {
        this.cateID = cateID;
        this.cateName = cateName;
        this.description = description;
    }

    @Column(name = "CateName", length = Integer.MAX_VALUE)
    private String cateName;

    @Column(name = "Description", length = Integer.MAX_VALUE)
    private String description;

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

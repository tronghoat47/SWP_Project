package com.project.swp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoleID implements Serializable {
    @Column(name = "RoleID")
    private Long RoleId;

    @ManyToOne
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

}

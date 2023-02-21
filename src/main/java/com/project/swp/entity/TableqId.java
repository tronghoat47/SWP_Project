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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TableqId implements Serializable {
    @Column(name = "TableqID")
    private String tableId;

    @ManyToOne
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

}

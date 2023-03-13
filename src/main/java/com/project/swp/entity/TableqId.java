package com.project.swp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TableqId implements Serializable {
    @Column(name = "TableqID")
    private String tableId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

}

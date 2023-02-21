package com.project.swp.entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "[Table]")
public class Tableq {

    @EmbeddedId
    private TableqId tableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ResID")
    @JoinColumn(name = "ResID", referencedColumnName = "ResID")
    private Restaurant restaurant;

    @Column(name = "Type")
    private String type;

    @Column(name = "TimeOrder")
    private String timeOrder;

    @Column(name = "[Description]")
    private String description;
}



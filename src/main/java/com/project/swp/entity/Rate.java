package com.project.swp.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Rate")
public class Rate {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RateId rateId;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Rating")
    private float rating;

}


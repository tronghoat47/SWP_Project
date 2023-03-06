package com.project.swp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleID implements Serializable {
    @Column(name = "RoleID")
    private Long roleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResID")
    private Restaurant restaurant;

}

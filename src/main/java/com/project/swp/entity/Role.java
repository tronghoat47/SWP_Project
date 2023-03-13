package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Role")
public class Role {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RoleID roleId;

    @Column(name = "RoleName", length = Integer.MAX_VALUE)
    private String roleName;

    @Column(name = "[View]")
    private boolean view;

    @Column(name = "[Edit]")
    private boolean edit;

    @Column(name = "[Create]")
    private boolean create;

    @Column(name = "[Delete]")
    private boolean delete;

}



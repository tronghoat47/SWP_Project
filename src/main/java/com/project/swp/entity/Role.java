package com.project.swp.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    private Long RoleId;

    @Id
    @ManyToOne
    @JoinColumn(name = "ResID")
    private Restaurant resID;

    @Column(name = "RoleName", length = Integer.MAX_VALUE)
    private String roleName;

    @Column(name = "[View]")
    private boolean view;

    public Restaurant getResID() {
        return resID;
    }

    public Role(Long id, Restaurant resID, String roleName, boolean view, boolean edit, boolean create, boolean delete) {
        this.RoleId = id;
        this.resID = resID;
        this.roleName = roleName;
        this.view = view;
        this.edit = edit;
        this.create = create;
        this.delete = delete;
    }

    public void setResID(Restaurant resID) {
        this.resID = resID;
    }

    @Column(name = "[Edit]")
    private boolean edit;

    @Column(name = "[Create]")
    private boolean create;

    @Column(name = "[Delete]")
    private boolean delete;

    public Role() {
    }

    public Long getRoleID() {
        return RoleId;
    }

    public void setRoleId(Long id) {
        this.RoleId = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}

package com.project.swp.service;

import com.project.swp.entity.Role;
import com.project.swp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role getDetailRole(int roleID, int resID){
        return roleRepo.findRolesByRoleId_RoleIdAndRoleId_Restaurant_ResID(roleID,resID);
    }
}

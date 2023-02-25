package com.project.swp.service;

import com.project.swp.entity.Role;
import com.project.swp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createRole(Role role){
        return roleRepo.save(role);
    }
//
//    public List<Role> getByRestaurant(int resId){
//        return roleRepo.findRolesByRoleId_Restaurant_ResID(resId).orElse(null);
//    }
}

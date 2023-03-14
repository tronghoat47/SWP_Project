package com.project.swp.service;

import com.project.swp.entity.Role;
import com.project.swp.repository.RoleRepo;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;
    public List<Role> getRolesByRestaurant(int resId){
        return roleRepo.findByRoleId_Restaurant_ResID(resId);
    }

    public Role getRoleByRestaurantAndRoleID(int resId, long roleId){
        return roleRepo.findFirstByRoleId_RoleIdAndRoleId_Restaurant_ResID(roleId, resId);
    }

    public Role saveRole(Role role){
       return roleRepo.save(role);
    }

}

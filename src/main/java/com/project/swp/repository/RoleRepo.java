package com.project.swp.repository;

import com.project.swp.entity.Role;
import com.project.swp.entity.RoleID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, RoleID> {
    Role findOneByRoleId(int id);

    List<Role> findByRoleId_Restaurant_ResID(int redId);

    Role findFirstByRoleId_RoleIdAndRoleId_Restaurant_ResID(long roleId, int resId);
}

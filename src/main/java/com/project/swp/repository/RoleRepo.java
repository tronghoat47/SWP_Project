package com.project.swp.repository;

import com.project.swp.entity.Role;
import com.project.swp.entity.RoleID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, RoleID> {
    Role findOneByRoleId(int id);

}

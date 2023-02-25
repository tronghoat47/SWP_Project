package com.project.swp.repository;

import com.project.swp.entity.Role;
import com.project.swp.entity.RoleID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, RoleID> {
//    List<Role> findRolesByRoleId_Restaurant_ResID(int ResId);
}

package com.project.swp.repository;

import com.project.swp.entity.Role;
import com.project.swp.entity.RoleID;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, RoleID> {

   public Role findRolesByRoleId_RoleIdAndRoleId_Restaurant_ResID(int roleID, int resID);
}

package com.project.swp.repository;

import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

    List<Staff> findStaffByRole_RoleId_Restaurant_ResID(int resID);

//    Optional<Staff> findStaffByRole_RoleId_Restaurant_ResID(in)

}

package com.project.swp.repository;

import com.project.swp.entity.Menu;
import com.project.swp.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepo extends JpaRepository<Staff, Integer> {
    Optional<Staff> findById(Integer id);
}

package com.project.swp.repository;

import com.project.swp.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

    Staff findOneByEmpId(int id);

    Staff deleteByEmpId(int id);

}

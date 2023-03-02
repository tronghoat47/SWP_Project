package com.project.swp.service;

import com.project.swp.entity.Staff;
import com.project.swp.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepo staffRepo;

    public List<Staff> listAllStaff(){
        return staffRepo.findAll();
    }
    public void saveStaff(Staff staff){
        staffRepo.save(staff);
    }

    public Staff getStaffById(int id) {
        return staffRepo.findOneByEmpId(id);
    }

    public Staff deleteStaffById(int id)  {
        return staffRepo.deleteByEmpId(id);
    }

}

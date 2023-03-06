package com.project.swp.service;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Restaurant;
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
    public void save(Staff staff){
        staffRepo.save(staff);
    }

    public Staff getDetailStaff(Integer id) {
        return staffRepo.findById(id).orElse(null);
    }

    public List<Staff> getEmployeeByResID(int resID){
        return staffRepo.findStaffByRole_RoleId_Restaurant_ResID(resID);
    }

    public Staff getId(Integer id) throws Exception {
        Optional<Staff> result = staffRepo.findById(id);
        try{
            if(result.isPresent()){ return result.get();}
        }catch (Exception ex){
            throw new Exception("Could not find staff with id: "+ id);
        }
        return null;
    }

    public Staff deleteById(Integer id) throws Exception {
        Optional<Staff> menuOptional = staffRepo.findById(id);
        if(menuOptional == null || menuOptional.isEmpty()){
            throw new Exception("Could not find staff with id: "+ id);
        }else{
            staffRepo.deleteById(id);
        }
        return null;
    }
}

package com.project.swp.service;

import com.project.swp.entity.Customer;
import com.project.swp.entity.Restaurant;
import com.project.swp.entity.Role;
import com.project.swp.entity.Staff;
import com.project.swp.repository.RestaurantRepo;
import com.project.swp.repository.RoleRepo;
import com.project.swp.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private RoleRepo roleRepo;

    // authenticate // =============================================================================
    public Staff authenticate(String username, String password, String roleName){
        Staff staff = staffRepo.findByUserNameAndPasswordAndRole_RoleName(username, password, roleName);
        return staff != null  ? staff : null;
    }

    public List<Staff> listAllStaff(){
        return staffRepo.findAll();
    }

    // CRUD Staff // ================================================================================
    public void saveStaff(Staff staff){
        staffRepo.save(staff);
    }

    public Staff getStaffById(int id) {
        return staffRepo.findOneByEmpId(id);
    }

    public Staff deleteStaffById(int id)  {
        return staffRepo.deleteByEmpId(id);
    }

    // CRUD Staff // ================================================================================

    public Restaurant getRestaurantByStaff(int id){
        Staff staff = getStaffById(id);
        return restaurantRepo.findOneByResID(staff.getRole().getRoleId().getRestaurant().getResID());
    }

    public List<Staff> getStaffByRestaurantID(int resId){
        List<Staff> staffs = staffRepo.findByRole_RoleId_Restaurant_ResID(resId);
        return staffs;
    }

}

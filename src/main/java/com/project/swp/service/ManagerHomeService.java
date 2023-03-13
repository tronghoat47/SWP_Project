package com.project.swp.service;

import com.project.swp.entity.*;
import com.project.swp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerHomeService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private RateRepo rateRepo;
    @Autowired
    private MenuRepo menuRepo;

    // Get order by restaurant //
    public List<Order> getOrderByResID(int resID){
        return orderRepo.findByRestaurant_ResID(resID);
    }

    // get restaurant by staff //
    public Restaurant getRestaurantByStaff(int id){
        Staff staff = getStaffById(id);
        return restaurantRepo.findOneByResID(staff.getRole().getRoleId().getRestaurant().getResID());
    }

    // get all staff by restaurant //
    public List<Staff> getStaffByRestaurantID(int resId){
        List<Staff> staffs = staffRepo.findByRole_RoleId_Restaurant_ResID(resId);
        return staffs;
    }

    // get staff by id //
    public Staff getStaffById(int id){
        return staffRepo.findOneByEmpId(id);
    }

    // get comments //
    public List<Rate> getAllRateByRestaurant(int id){
        return rateRepo.findByRateId_Restaurant_ResID(id);
    }

    // get menu //
    public List<Menu> getMenuByRestaurant(int id){
        return menuRepo.findMenusByRestaurant_ResID(id);
    }

}

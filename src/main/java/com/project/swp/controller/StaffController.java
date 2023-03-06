package com.project.swp.controller;


import com.project.swp.entity.Restaurant;

import com.project.swp.entity.Role;
import com.project.swp.entity.Staff;
import com.project.swp.service.RestaurantService;
import com.project.swp.service.RoleService;
import com.project.swp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;


@Controller
//@RequestMapping(value = "/staff")

public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private RoleService roleService;


    @GetMapping("/staff/{id}")
    public String getListOrderByResId(@PathVariable int id, Model model){
        Restaurant restaurant = restaurantService.getDetailRes(id);
        model.addAttribute("resID", restaurant);
        List<Staff> listStaffByResID = staffService.getEmployeeByResID(id);
        model.addAttribute("listStaffByResID",listStaffByResID);
        return "staff";
    }

    @GetMapping("staff/new/{resID}")
    public String showForAddNewStaff(@PathVariable int resID, Model model){
        model.addAttribute("resID",resID);
//        Staff staff = new Staff();
//        model.addAttribute("resID",resID);
        return "staff_form";
    }

    @PostMapping("staff/save/{resID}")
    public String addNewStaff(@PathVariable int resID,
                              @RequestParam(value = "empName") String empName,
                              @RequestParam(value = "email") String email,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "phoneNumber") String phoneNumber,
                              @RequestParam(value = "picture") String picture,
                              @RequestParam(value = "salary") double salary,
                              @RequestParam(value = "status") String status,
                              @RequestParam(value = "userName") String userName,
                              @RequestParam(value = "roleID") int roleID){
        Staff staff = new Staff();
        Restaurant restaurant = restaurantService.getDetailRes(resID);
        Role role = roleService.getDetailRole(roleID, resID);
        staff.setEmpName(empName);
        staff.setEmail(email);
        staff.setPassword(password);
        staff.setPhoneNumber(phoneNumber);
        staff.setPicture(picture);
        staff.setSalary(salary);
        staff.setStatus(status);
        staff.setTimeWork(String.valueOf(LocalDateTime.now()));
        staff.setUserName(userName);
        staff.setRole(role);
        staff.getRole().getRoleId().getRestaurant().setResID(restaurant.getResID());
        staffService.save(staff);
        return "staff/"+resID;
    }

    @GetMapping("/staff/edit/{id}")
    public String updateStaff(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Staff staff = staffService.getId(id);
            model.addAttribute("staff", staff);
            model.addAttribute("resID",id);
            return "update_staff";
        }catch (Exception ex){
            ra.addFlashAttribute("message", "Update staff successful");
            return "redirect:/staff/"+id;
        }
    }

    @PostMapping("staff/update/{resID}")
    public String updateStaff(@PathVariable int resID,
                              @RequestParam(value = "empID") int empID,
                              @RequestParam(value = "empName") String empName,
                              @RequestParam(value = "email") String email,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "phoneNumber") String phoneNumber,
                              @RequestParam(value = "picture") String picture,
                              @RequestParam(value = "salary") double salary,
                              @RequestParam(value = "status") String status,
                              @RequestParam(value = "userName") String userName,
                              @RequestParam(value = "roleID") int roleID){
        Staff staffCheck = staffService.getDetailStaff(empID);
        Role role = roleService.getDetailRole(roleID, resID);
        staffCheck.setEmpName(empName);
        staffCheck.setUserName(userName);
        staffCheck.setPassword(password);
        staffCheck.setEmail(email);
        staffCheck.setPhoneNumber(phoneNumber);
        staffCheck.setPicture(picture);
        staffCheck.setSalary(salary);
        staffCheck.setRole(role);
        staffCheck.setStatus(status);
        staffService.save(staffCheck);
        return "staff/"+resID;
    }




    @GetMapping("/staff/delete/{id}")
    public String deleteStaffById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            staffService.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/staff"+id;
    }
}

package com.project.swp.controller;

import com.project.swp.entity.Staff;
import com.project.swp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RequestMapping("/")
@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
    public String showListEmployee(Model model){
        List<Staff> listStaff = staffService.listAllStaff();
        model.addAttribute("listStaff",listStaff);
        return "staff";
    }

    @GetMapping("/staff/new")
    public  String showForAddNewStaff(Model model){
        Staff staff = new  Staff();
        model.addAttribute("staff" , staff);
        model.addAttribute("pageTitle","Add new staff");
        return "staff_form";
    }

    @PostMapping("/staff/save")
    public String addNewStaff(Staff staff, RedirectAttributes ra){
        staff.setStatus("dang lam viec");
        staffService.saveStaff(staff);
        ra.addFlashAttribute("message", "Employee has save successful");
        return "redirect:/staff";
    }

    @GetMapping("/staff/edit/{id}")
    public String updateStaff(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Staff staff = staffService.getStaffById(id);
            model.addAttribute("staff", staff);
            model.addAttribute("pageTitle","Edit information staff");
            return "staff_form";
        }catch (Exception ex){
            ra.addFlashAttribute("message", "Update staff successful");
            return "redirect:/staff";
        }
    }

    @GetMapping("/staff/delete/{id}")
    public String deleteStaffById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            staffService.deleteStaffById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/staff";
    }
}

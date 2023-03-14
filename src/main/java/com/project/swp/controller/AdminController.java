package com.project.swp.controller;

import com.project.swp.entity.*;
import com.project.swp.service.*;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private AdminHomeService adminHomeService;

    @Autowired
    private TableService tableService;

    // ***************************************************************************************************
    // ******************                  NEW BRANCH                   **********************************
    // ***************************************************************************************************

    @GetMapping("/addbranch")
    public String showFormAddBranch(Model model){

        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant", restaurant);

        return "admin/addBranch";
    }

    @PostMapping("/addbranch")
    public String addBranch(@ModelAttribute("restaurant") Restaurant restaurant, HttpSession session){
        Company company = (Company) session.getAttribute("company");
        restaurant.setCompany(company);
        restaurantService.saveRestaurant(restaurant);
        return "redirect:/home/admin";
    }


    // ***************************************************************************************************
    // ******************                  NEW STAFF                    **********************************
    // ***************************************************************************************************

    @GetMapping("/addstaff/{id}")
    public String showFormAddStaff(@PathVariable("id") int id, Model model){
        Staff staff = new Staff();
        Restaurant restaurant = restaurantService.getDetailRes(id);
        model.addAttribute("staff", staff);
        model.addAttribute("error", "An error is occurred");
        model.addAttribute("restaurant", restaurant);
        Role newRole = new Role();
        List<Role> roleList = roleService.getRolesByRestaurant(id);
        model.addAttribute("roleList", roleList);
        model.addAttribute("newRole", newRole);
        return "admin/addStaff";
    }

    @PostMapping("/addstaff/{id}")
    public String addStaff(@PathVariable("id") int id, Model model,
                           @RequestParam("roleIdd") String roleIdd,
                           @RequestParam("newRoleId") long newRoleId,
                           @ModelAttribute("staff") Staff staff,
                           @ModelAttribute("newRole") Role newRole,
                           HttpSession session){
        staff.setStatus("on");
        String time = String.valueOf(LocalDateTime.now());
        staff.setTimeWork(time);
        staff.setUserName(staff.getEmail());
        Company company =(Company) session.getAttribute("company");
        Restaurant restaurant = restaurantService.getDetailRes(id);

        long roleId = Long.parseLong(roleIdd);
        staff.setCompany(company);
        Role role = roleService.getRoleByRestaurantAndRoleID(id, roleId);
        if(role != null){
            staff.setRole(role);
            roleService.saveRole(role);
            staffService.saveStaff(staff);
            return "redirect:/home/admin/restaurant/" + id;
        }

        RoleID roleID = new RoleID();
        roleID.setRoleId(newRoleId);
        roleID.setRestaurant(restaurant);
        newRole.setRoleId(roleID);
        staff.setRole(newRole);
        roleService.saveRole(newRole);
        staffService.saveStaff(staff);
        return "redirect:/home/admin/restaurant/" + id;
    }

    @GetMapping("/table")
    public String showAllTable(Model model, HttpSession session){

        Company company = (Company) session.getAttribute("company");
        List<Restaurant> listRes = adminHomeService.getAllRestaurantByCompany(company.getCompanyID());

        List<List<Tableq>> listTableCompany = new ArrayList<>();

        for (Restaurant restaurant :  listRes) {
            List<Tableq> listTable = tableService.getTableByResId(restaurant.getResID());
            listTableCompany.add(listTable);
        }

        model.addAttribute("listTableCompany", listTableCompany);
        model.addAttribute("listRes", listRes);
        return "admin/manageTable";
    }

}

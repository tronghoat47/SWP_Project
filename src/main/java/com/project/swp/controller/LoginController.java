package com.project.swp.controller;

import com.project.swp.entity.Company;
import com.project.swp.entity.Customer;
import com.project.swp.entity.Restaurant;
import com.project.swp.entity.Staff;
import com.project.swp.service.CompanyService;
import com.project.swp.service.CustomerService;
import com.project.swp.service.RestaurantService;
import com.project.swp.service.StaffService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private RestaurantService restaurantService;

    // Customer // ==============================================================================================
    @GetMapping("/customer")
    public String CustomerLoginForm(Model model){
        model.addAttribute("errorNotice", null);
        return "customer/login";
    }
    @PostMapping("/customer")
    public String CustomerLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
        Customer customer = customerService.authenticate(username, password);

        if(customer != null){
            session.setAttribute("customer", customer);
            return ("redirect:/home/customer");
        }

        model.addAttribute("errorNotice", "Wrong username or password");
        return "customer/login";
    }


    // Manager // ==============================================================================================
    @GetMapping("/staff")
    public String ManagerLoginForm(Model model){
        model.addAttribute("errorNotice", null);
        return "manager/managerlogin";
    }

    @PostMapping("/staff")
    public String ManagerLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session){
        Staff staff = staffService.authenticate(username, password);

        if(staff != null){
            session.setAttribute("staff", staff);
            Restaurant restaurant = restaurantService.getDetailRes(staff.getRole().getRoleId().getRestaurant().getResID());
            session.setAttribute("restaurant", restaurant);
            if(staff.getRole().getRoleName().equals("manager")){
                return ("redirect:/home/manager");
            }else {
                return ("redirect:/home/employee");
            }
        }

        model.addAttribute("errorNotice", "Wrong username or password");
        return "manager/managerlogin" ;
    }

    // Administrator // ==============================================================================================

    @GetMapping("/admin")
    public String GetFormLoginAdmin(Model model){
        model.addAttribute("errorNotice", null);
        return "admin/login";
    }

    @PostMapping("/admin")
    public String AdminLogin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session){
        Company company = companyService.authenticate(email, password);
        if(company!=null){
            session.setAttribute("company", company);
            return ("redirect:/home/admin");
        }

        model.addAttribute("errorNotice", "Wrong username or password");
        return "admin/login";
    }

    // Logout // ======================================================================================================
    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.invalidate();
        return "redirect:/home/default";
    }


}

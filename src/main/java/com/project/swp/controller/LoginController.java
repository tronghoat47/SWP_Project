package com.project.swp.controller;

import com.project.swp.entity.Customer;
import com.project.swp.entity.Staff;
import com.project.swp.service.CustomerService;
import com.project.swp.service.StaffService;
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
    private HomeController homeController;

    @Autowired
    private StaffService staffService;

    // Customer // ==============================================================================================
    @GetMapping("/customer")
    public String CustomerLoginForm(Model model){
        model.addAttribute("errorNotice", null);
        return "customer/login";
    }
    @PostMapping("/customer")
    public String CustomerLogin(@RequestParam String username, @RequestParam String password, Model model){
        Customer customer = customerService.authenticate(username, password);
        model.addAttribute("errorNotice", "Wrong username or password");

//        return customer == null ? "customer/login" : homeController.dataHomePage(customer.getCusID(), model);

        return customer == null ? "customer/login" : ("redirect:/home/customer/"+customer.getCusID());

    }


    // Manager // ==============================================================================================
    @GetMapping("/manager")
    public String ManagerLoginForm(Model model){
        model.addAttribute("errorNotice", null);
        return "manager/managerlogin";
    }

    @PostMapping("/manager")
    public String ManagerLogin(@RequestParam String username, @RequestParam String password, Model model){
        Staff staff = staffService.authenticate(username, password, "manager");

        if(staff == null){
            model.addAttribute("errorNotice", "Wrong username or password");
            return "manager/managerlogin";
        }

        return staff == null ? "manager/managerlogin" : ("redirect:/home/manager/"+staff.getEmpId());
    }

}

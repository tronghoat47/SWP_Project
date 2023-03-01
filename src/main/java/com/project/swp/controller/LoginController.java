package com.project.swp.controller;

import com.project.swp.entity.Customer;
import com.project.swp.service.CustomerService;
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

    @GetMapping("/customer")
    public String CustomerLoginForm(Model model){
        model.addAttribute("errorNotice", null);
        return "login";
    }
    @PostMapping("/customer")
    public String CustomerLogin(@RequestParam String username, @RequestParam String password, Model model){
        Customer customer = customerService.authenticate(username, password);
        model.addAttribute("errorNotice", "Wrong username or password");

        return customer == null ? "login" : homeController.dataHomePage(customer.getCusID(), model);
    }

    @GetMapping("/manager")
    public String ManagerLoginForm(Model model){
        model.addAttribute("errorNotice", null);
        return "login";
    }
    @PostMapping("/manager")
    public String ManagerLogin(@RequestParam String username, @RequestParam String password, Model model){
        Customer customer = customerService.authenticate(username, password);
        model.addAttribute("errorNotice", "Wrong username or password");

        return customer == null ? "login" : homeController.dataHomePage(customer.getCusID(), model);
    }

}

package com.project.swp.controller;

import com.project.swp.entity.Customer;
import com.project.swp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private HomeController homeController;

// Register for customer //
    @GetMapping("/customer")
    public String RegisterCusForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("error", null);
        return "registercustomer";
    }

    @PostMapping("/customer")
    public String RegisterCustomer(Customer customer,Model model){
        Customer temp = customerService.findByUsername(customer.getUserName());
        return temp != null? "registercustomer" : homeController.dataHomePage(customer.getCusID(), model);
    }

}

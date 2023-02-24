package com.project.swp.controller;

import com.project.swp.DAO.CustomerDAO;
import com.project.swp.entity.Customer;
import com.project.swp.repository.CustomerRepo;
import com.project.swp.service.CustomerService;
//import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public String login(@RequestBody Customer customer){
        Customer checkCus = customerService.createCustomer(customer);

        if(checkCus!=null){
//            session.setAttribute("user", checkCus);
            return "redirect:/error";
        }else {
            return "redirect:/home";
        }

    }
}

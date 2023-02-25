package com.project.swp.controller;

import com.project.swp.DAO.CustomerDAO;
import com.project.swp.entity.Customer;
import com.project.swp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/login")
    public String getMappingPage(Model model){
        CustomerDAO customerDAO = new CustomerDAO();
//        customerDAO.setUsername("username");
//        customerDAO.setPassword("password");
        model.addAttribute("customerDAO", customerDAO);
        return "login";
    }

    @PostMapping("/login")
    public String login(CustomerDAO customerDAO, Model model){
        Customer customer = customerService.authenticate(customerDAO.getUsername(), customerDAO.getPassword());
        List<Customer> list = customerService.getAllCus("son");
        model.addAttribute("list", list);
        if(customer!=null){
            return "/home";
        }
        return "/home";
    }
//    @GetMapping("/logout")
//    public String logout(HttpSession session){
//        session.invalidate();
//        return "login";
//    }

}

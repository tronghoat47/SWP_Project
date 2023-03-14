package com.project.swp.controller;

import com.project.swp.entity.Customer;
import com.project.swp.entity.Order;
import com.project.swp.service.CustomerService;
import com.project.swp.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/profile")
    public String profileCustomer(Model model, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        model.addAttribute("customer", customer);
        List<Order> listOrder = orderService.getListOrderByCustomer(customer.getCusID());
        model.addAttribute("listOrder", listOrder);
        return "customer/profile";
    }

    @PostMapping("/profile")
    public String editProfileCustomer(@ModelAttribute("customer") Customer customer, HttpSession session) {
        customerService.customerUpdateAndAdd(customer);
        session.setAttribute("customer", customer);
        return "redirect:/customer/profile";
    }
}

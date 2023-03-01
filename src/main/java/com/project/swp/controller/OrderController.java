package com.project.swp.controller;

import com.project.swp.entity.Order;
import com.project.swp.entity.Staff;
import com.project.swp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order")
    public String getAllList(Model model){
        List<Order> listOrder = orderService.ListOrder();
        model.addAttribute("listOrder", listOrder);
        return  "order";
    }

    @GetMapping("/order/new")
    public String showFormAddNewOrder(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "order_form";
    }

    @PostMapping("/order/save")
    public String addNewOrder(Order order, RedirectAttributes ra){
        orderService.save(order);
        ra.addFlashAttribute("message", "Order has save successful");
        return "redirect:/order";
    }

    @GetMapping("/order/edit/{id}")
    public String updateOrder(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Order order = orderService.getId(id);
            model.addAttribute("order", order);
            model.addAttribute("pageTitle","Edit information order");
            return "order_form";
        }catch (Exception ex){
            ra.addFlashAttribute("message", "Update order successful");
            return "redirect:/order";
        }
    }

    @GetMapping("/order/delete/{id}")
    public String deleteOrderById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            orderService.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/order";
    }

}

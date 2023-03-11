package com.project.swp.controller;

import com.project.swp.entity.Order;
import com.project.swp.entity.Staff;
import com.project.swp.service.OrderService;
import com.project.swp.service.RestaurantService;
import com.project.swp.service.TableService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private TableService tableService;

    @GetMapping("/{id}")
    public String getOrderDetail(@PathVariable int id, Model model){
        Order order =  orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "collection/detailOrder";
    }

    @GetMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") int id, Model model, RedirectAttributes ra){
        try{
            Order order = orderService.getById(id);
            model.addAttribute("order", order);
            model.addAttribute("resID",id);
            return "manager/updateOrder";
        }catch (Exception ex){
            ra.addFlashAttribute("message","Update food successfully");
            return "redirect:/home/manager";
        }
    }

    @PutMapping("/update/{id}")
    public String updateMenu(@ModelAttribute("order") Order order, HttpSession session){
        Staff staff = (Staff) session.getAttribute("staff");
        order.setStaff(staff);
        if(order.getStaff() == null){
            order.setStaff(staff);
        }
        orderService.save(order);
        return "redirect:/home/manager";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderById(@PathVariable("id") int id, RedirectAttributes ra){
        try{
            orderService.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/home/manager";
    }

}

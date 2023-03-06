package com.project.swp.controller;

import com.project.swp.entity.Order;
import com.project.swp.entity.Staff;
import com.project.swp.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public String getOrderDetail(@PathVariable int id, Model model){
        Order order =  orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "collection/detailOrder";
    }

    @GetMapping("/edit/{id}")
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


    @PostMapping("/update/{id}")
    public String updateMenu(@PathVariable int id,
                             @RequestParam(value = "orderID") int orderID,
                             @RequestParam(value = "methodPayment") String methodPayment,
                             @RequestParam(value = "timeCancel") String timeCancle,
                             @RequestParam(value = "timeOrder")String timeOrder,
                             @RequestParam(value = "total") double total,
//                             @RequestParam(value = "tableID") String tableID,
                             @RequestParam(value = "employeeID") int employeeID,
                             HttpSession session){
        Order orderCheck = orderService.getById(orderID);
        Staff staff = (Staff) session.getAttribute("manager");
        orderCheck.setMethodPayment(methodPayment);
        orderCheck.setTimeOrder(timeOrder);
        orderCheck.setTimeCancel(timeCancle);
        orderCheck.setTotal(total);
        orderCheck.setStaff(staff);
        orderService.save(orderCheck);
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

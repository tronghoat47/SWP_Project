package com.project.swp.controller;

import com.project.swp.entity.*;
import com.project.swp.service.OrderService;
import com.project.swp.service.RestaurantService;
import com.project.swp.service.StaffService;
import com.project.swp.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private TableService tableService;

    @Autowired
    private StaffService staffService;

    // Get List Order By Restaurant
    @GetMapping("/{id}")
    public String getListOrderByResId(@PathVariable Integer id, Model model){
        Restaurant restaurant = restaurantService.getDetailRes(id);
        model.addAttribute("detail", restaurant);
        List<Order> listOrderByResDetail = orderService.getListOrderByResID(id);
        model.addAttribute("listOrderByResDetail",listOrderByResDetail);
        return  "order";
    }


    //Update Order
    @GetMapping("/edit/{id}")
    public String updateOrder(@PathVariable("id") int id, Model model, RedirectAttributes ra){
        try{
            Order order = orderService.getIDOrder(id);
            model.addAttribute("order", order);
            model.addAttribute("resID",id);
            return "UpdateOrder";
        }catch (Exception ex){
            ra.addFlashAttribute("message","Update food successfully");
            return "redirect:/"+id;
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
                             @RequestParam(value = "employeeID") int employeeID)throws Exception {
        Order orderCheck = orderService.getIDOrder(orderID);
        Staff staff = staffService.getDetailStaff(employeeID);
//        Tableq tableq = tableService.getTableID(tableID);
        orderCheck.setMethodPayment(methodPayment);
        orderCheck.setTimeOrder(timeOrder);
        orderCheck.setTimeCancel(timeCancle);
        orderCheck.setTotal(total);
        orderCheck.setStaff(staff);
//        orderCheck.setTable(tableq);
        orderService.save(orderCheck);
        return "/order/"+id;
    }



    // Delete order in list
    @GetMapping("/delete/{id}")
    public String deleteOrderById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            orderService.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/order/"+id;
    }

}

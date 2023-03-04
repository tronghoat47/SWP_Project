package com.project.swp.controller;

import com.project.swp.entity.*;
import com.project.swp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private CustomerHomeService customerHomeService;
    @Autowired
    private ManagerHomeService managerHomeService;

    // Customer place // =========================================================================================

    @GetMapping("/customer/{id}")
    public String dataHomePage(@PathVariable int id, Model model) {
        List<Restaurant> listHotRestaurant = restaurantService.getListHotRestaurant();
        model.addAttribute("listHotRestaurant", listHotRestaurant);
        List<String> listCity = restaurantService.getListCity();
        model.addAttribute("listCity", listCity);
        List<Company> listCompany = customerHomeService.getListCompany();
        model.addAttribute("listCompany", listCompany);
        List<String> listCategoryRes = restaurantService.getCategoryRes();
        model.addAttribute("listCategoryRes", listCategoryRes);
        List<Menu> listHotFood = menuService.getListHotFood();
        model.addAttribute("listHotFood", listHotFood);
        return "customer/home";
    }

    // Manager place // =========================================================================================
    @GetMapping("/manager/{id}")
    public String ManagerHome(@PathVariable int id, Model model) {
        Staff staff = managerHomeService.getStaffById(id);
        model.addAttribute("staff", staff);
        Restaurant restaurant = managerHomeService.getRestaurantByStaff(staff.getEmpId());
        model.addAttribute("restaurant", restaurant);
        List<Staff> listEmployee = managerHomeService.getStaffByRestaurantID(restaurant.getResID());
        model.addAttribute("listEmployee", listEmployee);
        List<Order> orderList = managerHomeService.getOrderByResID(restaurant.getResID());
        model.addAttribute("listOrder", orderList);
        List<Rate> rateList = managerHomeService.getAllRateByRestaurant(restaurant.getResID());
        model.addAttribute("listRate", rateList);
        List<Menu> menuList = managerHomeService.getMenuByRestaurant(restaurant.getResID());
        model.addAttribute("listMenu", menuList);
        return "manager/mnghome";
    }
}

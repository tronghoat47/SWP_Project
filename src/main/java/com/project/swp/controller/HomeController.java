package com.project.swp.controller;

import com.project.swp.entity.Company;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.service.CompanyService;
import com.project.swp.service.MenuService;
import com.project.swp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/customer")
    public String dataHomePage(@RequestParam int id, Model model) {
        List<Restaurant> listHotRestaurant = restaurantService.getListHotRestaurant();
        model.addAttribute("listHotRestaurant", listHotRestaurant);
        List<String> listCity = restaurantService.getListCity();
        model.addAttribute("listCity", listCity);
        List<Company> listCompany = companyService.getListCompany();
        model.addAttribute("listCompany", listCompany);
        List<String> listCategoryRes = restaurantService.getCategoryRes();
        model.addAttribute("listCategoryRes", listCategoryRes);
        List<Menu> listHotFood = menuService.getListHotFood();
        model.addAttribute("listHotFood", listHotFood);
        return "home";
    }

    @GetMapping("/customer")
    public String ManagerHome(@RequestParam int id, Model model) {

        return "mnghome";
    }

    @PostMapping("/search")
    public String  searchRestaurant(@RequestParam(name = "company", required = false) int companyId,
                                   @RequestParam(name = "city", required = false, defaultValue = "") String city,
                                   @RequestParam(name = "restaurantName", required = false, defaultValue = "") String restaurantName,
                                   Model model){
        Company company = companyService.findCompanyByName(companyId);


        List<Restaurant> listRestaurant = restaurantService.searchRestaurant(company, city, restaurantName);
        model.addAttribute("listRestaurant", listRestaurant);
//        return listRestaurant;
        return "searchPage";
    }
}

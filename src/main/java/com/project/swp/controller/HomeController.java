package com.project.swp.controller;

import com.project.swp.entity.Company;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public String dataHomePgae(Model model) {
        List<Restaurant> listHotRestaurant = homeService.getListHotRestaurant();
        model.addAttribute("listHotRestaurant", listHotRestaurant);
        List<String> listCity = homeService.getListCity();
        model.addAttribute("listCity", listCity);
        List<Company> listCompany = homeService.getListCompany();
        model.addAttribute("listCompany", listCompany);
        List<String> listCategoryRes = homeService.getCategoryRes();
        model.addAttribute("listCategoryRes", listCategoryRes);
        List<Menu> listHotFood = homeService.getListHotFood();
        model.addAttribute("listHotFood", listHotFood);
        return "home";
    }

    @PostMapping("/search")
    public String searchRestaurant(@RequestParam(name = "company", required = false) int companyId,
                                   @RequestParam(name = "city", required = false) String city,
                                   @RequestParam(name = "restaurantName", required = false) String restaurantName,
                                   Model model){
        Company company = homeService.findCompanyByName(companyId);

        List<Restaurant> listRestaurant = homeService.searchRestaurant(company, city, restaurantName);

        return "searchPage";
    }
}

package com.project.swp.controller;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.MenuRepo;
import com.project.swp.service.CategoryMenuService;
import com.project.swp.service.MenuService;
import com.project.swp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping(value = "restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private CategoryMenuService categoryMenuService;
    @GetMapping("/customer/{id}")
    public String  getDetailRestaurant(@PathVariable Integer id, Model model) {
        Restaurant restaurant = restaurantService.getDetailRes(id);
        model.addAttribute("detail", restaurant);
        List<Menu> listMenuDetailRes = menuService.getListMenuByResId(id);
        model.addAttribute("listMenuDetailRes", listMenuDetailRes);
        List<CategoryMenu> categoryMenus = categoryMenuService.getListCategory();
        model.addAttribute("listCategoryMenu", categoryMenus);
//        return listMenuByResID;
//        return restaurant;
        return "detailRestaurant";
    }

    @PostMapping("/customer/searchMenu")
    public String getListMenuBySearch(@RequestParam(name = "resID") int resID, @RequestParam(required = false, name = "priceFrom", defaultValue = "" ) String priceFrom,
                                            @RequestParam(required = false, name = "priceTo", defaultValue = "") String priceTo,
                                            @RequestParam(required = false, name = "foodName", defaultValue = "") String foodName,
                                            @RequestParam(required = false, name = "cateMenuID", defaultValue = "0") String cateMenuID,
                                             Model model) {
        Restaurant restaurant = restaurantService.getDetailRes(resID);
        model.addAttribute("detail", restaurant);
        List<CategoryMenu> categoryMenus = categoryMenuService.getListCategory();
        model.addAttribute("listCategoryMenu", categoryMenus);
        CategoryMenu categoryMenu = categoryMenuService.getCategoryMenuByCateID(Integer.parseInt(cateMenuID));
        List<Menu> listMenuDetailRes = menuService.getListMenusBySearch(categoryMenu, foodName, priceFrom, priceTo, restaurant);
        model.addAttribute("listMenuDetailRes", listMenuDetailRes);
        return "detailRestaurant";
    }

}

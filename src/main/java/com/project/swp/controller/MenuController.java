package com.project.swp.controller;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.service.CategoryMenuService;
import com.project.swp.service.MenuService;
import com.project.swp.service.RestaurantService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService service;
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CategoryMenuService categoryMenuService;
    @GetMapping("/menu/{id}")
    public String loadDataMenu(@PathVariable Integer id, Model model){
        Restaurant restaurant = restaurantService.getDetailRes(id);
        model.addAttribute("detail",restaurant);
        List<Menu> listMenuDetailRes =  service.getListMenuByResId(restaurant);
        model.addAttribute("listMenuDetailRes", listMenuDetailRes);
        return "menu";
    }

    @GetMapping("menu/new/{id}")
    public String showFormAddNew(@PathVariable int id, Model model) {
        model.addAttribute("resID", id);
        return "menu_form";
    }


    @PostMapping("/menu/save/{id}")
    public String addNewFood(@PathVariable int id,
                             @RequestParam(value = "foodName") String foodName,
                             @RequestParam(value = "descriptionFood") String decriptionFood,
                             @RequestParam(value = "picture") String picture,
                             @RequestParam(value = "price") double price,
                             @RequestParam(value = "cateID") int cateID){
        Menu menu = new Menu();
            menu.setFoodName(foodName);
            menu.setDescriptionFood(decriptionFood);
            menu.setPicture(picture);
            menu.setPrice(price);
            menu.setStatusFood(true);
            CategoryMenu categoryMenu = categoryMenuService.getDetailCate(cateID);
            menu.setCategoryMenu(categoryMenu);
            Restaurant restaurant = restaurantService.getDetailRes(id);
            menu.setRestaurant(restaurant);
            service.save(menu);
        return "menu/menu/"+id;
    }



    @GetMapping("/menu/edit/{id}")
    public String updateMenu(@PathVariable("id") int id, Model model, RedirectAttributes ra){
        try{
            Menu menu = service.getID(id);
            model.addAttribute("menu", menu);
            model.addAttribute("resID",id);
            return "update";
        }catch (Exception ex){
            ra.addFlashAttribute("message","Update food successfully");
            return "redirect:/menu/menu"+id;
        }
    }
    @PostMapping("/menu/update/{id}")
    public String updateMenu(@PathVariable int id,
                             @RequestParam(value = "foodID") int foodID,
                             @RequestParam(value = "foodName") String foodName,
                             @RequestParam(value = "descriptionFood") String decriptionFood,
                             @RequestParam(value = "picture") String picture,
                             @RequestParam(value = "price") double price,
                             @RequestParam(value = "cateID") int cateID) throws Exception {
        Menu menuCheck = service.getID(foodID);
        CategoryMenu categoryMenu = categoryMenuService.getDetailCate(cateID);
            menuCheck.setFoodName(foodName);
            menuCheck.setDescriptionFood(decriptionFood);
            menuCheck.setPicture(picture);
            menuCheck.setPrice(price);
            menuCheck.setCategoryMenu(categoryMenu);
            service.save(menuCheck);
        return "menu/menu/"+id;
    }



    @GetMapping("/menu/delete/{id}")
    public String deleteFoodById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            service.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "/menu/menu/"+id;
    }
}

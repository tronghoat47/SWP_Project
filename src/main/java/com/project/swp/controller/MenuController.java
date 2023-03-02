package com.project.swp.controller;

import com.project.swp.entity.Menu;
import com.project.swp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService service;

    @GetMapping("{resid}/menu")
    public String showListFoodInMenu(@PathVariable int resid,Model model){
        List<Menu> listMenu = service.getListMenuByResId(resid);
        model.addAttribute("listMenu", listMenu);
        return "menu";
    }

    @GetMapping("/menu/new")
    public String showNewForm(Model model){
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        model.addAttribute("pageTitle", "Add New Food");
        return "menu_form";
    }


    @PostMapping("/menu/save")
    public String addNewFood(Menu menu, RedirectAttributes ra, Model model){
        menu.setStatusFood(true);
        menu.setRestaurant(menu.getRestaurant());
        model.addAttribute("menu", menu);
        service.save(menu);
        ra.addFlashAttribute("message", "Food has been save successfully");
        return "redirect:/menu";
    }
    @GetMapping("/menu/edit/{id}")
    public String updateMenu(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Menu menu = service.getById(id);
            model.addAttribute("menu", menu);
            model.addAttribute("pageTitle","Edit Food: "+id);
            return "menu_form";
        }catch (Exception ex){
            ra.addFlashAttribute("message","Update food successfully");
            return "redirect:/menu";
        }
    }

    @GetMapping("/menu/delete/{id}")
    public String deleteFoodById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            service.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/menu";
    }
}

package com.project.swp.controller;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.repository.CategoryMenuRepo;
import com.project.swp.service.CategoryMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryMenuController {

    @Autowired
    private CategoryMenuService categoryMenuService;

    private CategoryMenuRepo categoryMenuRepo;
    @GetMapping("/categoryMenu")
    public String showListCategoryMenu(Model model){
        List<CategoryMenu> listCategoryMenu = categoryMenuService.listAllCategoryMenu();
        model.addAttribute("listCategoryMenu", listCategoryMenu);
        return "categoryMenu";
    }

    @GetMapping("/categoryMenu/new")
    public String showNewForm(Model model){
        CategoryMenu categoryMenu = new CategoryMenu();
        model.addAttribute("categoryMenu", categoryMenu);
        model.addAttribute("pageTitle", "Add New Category Menu");
        return "category_form_add";
    }

    @PostMapping("/categoryMenu/save")
    public String addNewCategory(CategoryMenu categoryMenu, RedirectAttributes ra){
        categoryMenuService.save(categoryMenu);
        ra.addFlashAttribute("message", "Category food has been save successfully");
        return "redirect:/categoryMenu";
    }

//    @GetMapping("categoryMenu/edit/{id}")
//    public String updateCategoryMenu(CategoryMenu categoryMenu, RedirectAttributes ra){
//
//    }
//    @PutMapping("/update/{id}")
//    ResponseEntity<CategoryMenu> updateCategoryMenu(@RequestBody CategoryMenu newCategoryMenu, @PathVariable Integer id){
//        String updateCategoryMenu = categoryMenuRepo.findById(id)
//                .map(categoryMenu -> {
//                    categoryMenu.setCateName(newCategoryMenu.getCateName());
//                    categoryMenu.setDescription(newCategoryMenu.getDescription());
//                    categoryMenuRepo.save(categoryMenu);
//                    return "redirect:/categoryMenu";
//                }).orElseGet(() ->{
//                   newCategoryMenu.setCateID(id);
//                   return String.valueOf(categoryMenuRepo.save(newCategoryMenu));
//                });
//                return null;
//    }
    @GetMapping("/categoryMenu/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            categoryMenuService.deleteById(id);
        }catch (Exception ex){
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return "redirect:/categoryMenu";
    }


}

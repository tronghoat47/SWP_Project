package com.project.swp.controller;

import com.project.swp.entity.Rate;
import com.project.swp.entity.RateId;
import com.project.swp.entity.Restaurant;
import com.project.swp.service.RateService;
import com.project.swp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RateController {
    @Autowired
    private RateService rateService;

    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/rate/{id}")
    public String getListCommentByResID(@PathVariable("id") int resID, Model model){
        Restaurant restaurant = restaurantService.getDetailRes(resID);
        model.addAttribute("detail",restaurant);
        List<Rate> listCommnetByResID = rateService.getListCommnetByResID(resID);
        model.addAttribute("listCommnetByResID",listCommnetByResID);
        return "rate";
    }


}

package com.project.swp.controller;

import com.project.swp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("testRevenue")
    public String Revenue(Model model){
        if(invoiceService.getRevenue() == 0){
            model.addAttribute("message", "The restaurant is not maybe revenue");
        }else{
            double revenueRestaurant = invoiceService.getRevenue();
            model.addAttribute("revenueRestaurant", revenueRestaurant);
            return "revenue";
        }
        return null;
    }
}

package com.project.swp.controller;

import com.project.swp.entity.Company;
import com.project.swp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/copmany")
    public String showListCompany(Model model){
        List<Company> listCompany = companyService.ListAllCompanies();
        model.addAttribute("listCompany",listCompany);
        return "company";
    }
//@GetMapping("/company")
//@ResponseBody
//public List<Company> showListCompany(Model model){
//    List<Company> listCompany = companyService.ListAllCompanies();
//    model.addAttribute("listCompany",listCompany);
//    return "redirect:/company";
//}



}

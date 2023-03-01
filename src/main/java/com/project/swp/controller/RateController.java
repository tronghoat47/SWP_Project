package com.project.swp.controller;

import com.project.swp.entity.Rate;
import com.project.swp.entity.RateId;
import com.project.swp.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class RateController {
    @Autowired
    private RateService rateService;
    
    @GetMapping("rate")
    @ResponseBody
    public List<Rate> Comment(){
        return rateService.getComment();
    }


}

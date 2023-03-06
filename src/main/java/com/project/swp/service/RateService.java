package com.project.swp.service;

import com.project.swp.entity.Order;
import com.project.swp.entity.Rate;

import com.project.swp.repository.RateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {
    @Autowired
    private RateRepo rateRepo;

    public List<Rate> getComment(){
        return rateRepo.findAll();
    }

    public List<Rate> getListCommnetByResID(int resID){
        return rateRepo.findRatesByRateId_Restaurant_ResID(resID);
    }

}

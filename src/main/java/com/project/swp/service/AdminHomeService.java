package com.project.swp.service;

import com.project.swp.DTO.RevenueDTO;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.OrderRepo;
import com.project.swp.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminHomeService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private OrderRepo orderRepo;

    public List<Restaurant> getAllRestaurantByCompany(int id){
        return restaurantRepo.findByCompany_CompanyID(id);
    }

    public List<RevenueDTO> getRevenueByMonth(int redId){
        return orderRepo.getRevenueByMonthAndYearAndResId(redId);
    }
}

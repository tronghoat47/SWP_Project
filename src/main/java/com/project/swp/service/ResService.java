package com.project.swp.service;

import com.project.swp.entity.Company;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<Restaurant> getRestaurantByName(String name){
        return restaurantRepo.findRestaurantsByResName(name).orElse(null);
    }

}

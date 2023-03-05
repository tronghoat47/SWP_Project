package com.project.swp.service;

import com.project.swp.entity.Company;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.CompanyRepo;
import com.project.swp.repository.MenuRepo;
import com.project.swp.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerHomeService {
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private MenuRepo menuRepo;

    // Home user //

    public List<Company> getListCompany() {
        return companyRepo.findAll();
    }
    public List<Restaurant> getListHotRestaurant(){
        return restaurantRepo.findTop6ByOrderByRatingPointDesc();
    }
    public List<String> getListCity() {
        return restaurantRepo.findDistinctCity();
    }
    public List<String> getCategoryRes() {
        return restaurantRepo.findCategoryRest();
    }

    public List<Menu> getListHotFood() {
        return menuRepo.FindListHotFood();
    }
}

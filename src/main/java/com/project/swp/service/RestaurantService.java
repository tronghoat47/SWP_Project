package com.project.swp.service;

import com.project.swp.entity.Company;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.MenuRepo;
import com.project.swp.repository.OrderRepo;
import com.project.swp.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private MenuRepo menuRepo;
    @Autowired
    private OrderRepo orderRepo;

    // Get for customer //
    public Restaurant getDetailRes(Integer id) {
        return restaurantRepo.findRestaurantsByResID(id).orElse(null);
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

    public List<Restaurant> searchRestaurant(Company company, String city, String restaurantName, String category) {
        if(company != null)
            return restaurantRepo.findRestaurantsByCompanyAndCityContainingIgnoreCaseAndAndResNameContainingIgnoreCaseAndCategoryResContainsIgnoreCase(company, city, restaurantName, category);
        else
            return restaurantRepo.findRestaurantsByCityContainingIgnoreCaseAndAndResNameContainingIgnoreCaseAndCategoryResContainsIgnoreCase(city, restaurantName, category);
    }

    // ADMIN // ===============================================================

    public Restaurant saveRestaurant(Restaurant restaurant){
        return restaurantRepo.save(restaurant);
    }



}

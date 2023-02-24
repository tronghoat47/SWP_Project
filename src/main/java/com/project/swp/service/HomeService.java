package com.project.swp.service;

import com.project.swp.entity.Company;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.CompanyRepo;
import com.project.swp.repository.MenuRepo;
import com.project.swp.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private RestaurantRepo restaurantRepo;
    public List<Restaurant> getListHotRestaurant(){
        return restaurantRepo.findTop6ByOrderByRatingPointDesc();
    }

    public List<String> getListCity() {
        return restaurantRepo.findDistinctCity();
    }
    public List<String> getCategoryRes() {
        return restaurantRepo.findCategoryRest();
    }
    public List<Restaurant> searchRestaurant(Company company, String city, String restaurantName) {
        return restaurantRepo.findRestaurantsByCompanyAndCityAndResName(company, city, restaurantName);
    }

    @Autowired
    private CompanyRepo companyRepo;
    public List<Company> getListCompany() {
        return companyRepo.findAll();
    }
    public Company findCompanyByName(int companyId) {
        return companyRepo.findCompanyByCompanyID(companyId);
    }

    @Autowired
    private MenuRepo menuRepo;
    public List<Menu> getListHotFood() {
        return menuRepo.FindListHotFood();
    }



}

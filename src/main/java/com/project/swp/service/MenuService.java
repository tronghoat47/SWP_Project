package com.project.swp.service;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepo menuRepo;
    public List<Menu> getListHotFood() {
        return menuRepo.FindListHotFood();
    }

    public List<Menu> getListMenuByResId(Restaurant restaurant) {
        return  menuRepo.findMenusByRestaurant(restaurant);
    }

    public List<Menu> getListMenusBySearch(CategoryMenu categoryMenu, String foodName, String priceFromRaw, String priceToRaw, Restaurant restaurant){
        Double priceFrom, priceTo;
        if(priceFromRaw.equals(""))
            priceFrom = menuRepo.getMinPriceFood();
        else
            priceFrom = Double.valueOf(priceFromRaw);

        if(priceToRaw.equals(""))
            priceTo = menuRepo.getMaxPriceFood();
        else
            priceTo = Double.valueOf(priceToRaw);
        if(categoryMenu!= null)
            return  menuRepo.getMenusByCategoryMenuAndFoodNameContainingIgnoreCaseAndPriceBetweenAndRestaurant(categoryMenu, foodName, priceFrom, priceTo, restaurant);
        else
            return menuRepo.getMenusByFoodNameContainingIgnoreCaseAndPriceBetweenAndRestaurant(foodName, priceFrom, priceTo, restaurant);
    }

}

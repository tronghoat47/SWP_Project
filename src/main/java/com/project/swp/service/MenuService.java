package com.project.swp.service;

import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.MenuRepo;
import com.project.swp.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;
    public List<Menu> listAllFood(){
        return menuRepo.findAll();
    }

    public List<Menu> getListMenuByResId(Restaurant restaurant) {
        return  menuRepo.findMenusByRestaurant(restaurant);
    }


    public void save(Menu menu){
        menuRepo.save(menu);
    }

    public Menu getID(int id) throws Exception {
        Optional<Menu> result = menuRepo.findByFoodId(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new Exception("Could not find and food with ID: " + id);
    }

    public Menu deleteById(Integer id) throws Exception {
        Optional<Menu> menuOptional = menuRepo.findById(id);
        if(menuOptional == null || menuOptional.isEmpty()){
            throw new Exception("Could not find and food with ID: " + id);
        }
        else{
            menuRepo.deleteById(id);
        }
        return null;
    }

}

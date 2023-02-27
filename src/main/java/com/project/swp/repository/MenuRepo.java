package com.project.swp.repository;

import com.project.swp.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {

        @Modifying
        @Query("UPDATE Menu m SET m.foodName = :foodName, m.descriptionFood = :descriptionFood, m.picture = :picture," +
                " m.price = :price, m.statusFood = :statusFood , m.categoryMenu.cateID = :cateID, m.restaurant.resID = :resID" +
                " where m.foodId = :foodId")
        void updateMenu(int foodId, String foodName, String descriptionFood, String picture, Double price, Boolean statusFood,
                        int cateID, int resID);

        Optional<Menu> findById(Integer id);

}

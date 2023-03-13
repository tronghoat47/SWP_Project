package com.project.swp.repository;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepo extends JpaRepository<Menu, Integer> {
    List<Menu> findMenusByRestaurant_ResID(int resId);

    @Query("select m from Menu m join Invoice i on m.foodId=i.invoiceID.menu.foodId " +
            "group by m.foodId order by sum (i.actualQuantity) desc limit 10")
    List<Menu> FindListHotFood();

    @Query("select max (m.price)from Menu m")
    Double getMaxPriceFood();

    @Query("select min (m.price)from Menu m")
    Double getMinPriceFood();

    List<Menu> getMenusByCategoryMenuAndFoodNameContainingIgnoreCaseAndPriceBetweenAndRestaurant(CategoryMenu categoryMenu, String foodName, Double priceFrom, Double priceTo, Restaurant restaurant);

    List<Menu> getMenusByFoodNameContainingIgnoreCaseAndPriceBetweenAndRestaurant(String foodName, Double priceFrom, Double priceTo, Restaurant restaurant);

//    List<Menu>
}

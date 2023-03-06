package com.project.swp.repository;

import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {

        Optional<Menu> findByFoodId(Integer id);

        Optional<Menu> findByRestaurant_ResID(int resID);

        List<Menu> findMenusByRestaurant(Restaurant restaurant);
}

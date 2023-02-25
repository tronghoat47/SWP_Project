package com.project.swp.repository;

import com.project.swp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    Optional<List<Restaurant>> findRestaurantsByResName(String resName);
}

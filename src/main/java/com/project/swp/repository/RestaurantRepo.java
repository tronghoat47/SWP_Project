package com.project.swp.repository;

import com.project.swp.entity.Company;
import com.project.swp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
    public List<Restaurant> findTop6ByOrderByRatingPointDesc();

    @Query("select DISTINCT r.city from Restaurant r")
    public List<String> findDistinctCity();

    @Query("select distinct r.categoryRes from Restaurant r")
    public List<String> findCategoryRest();

    public List<Restaurant> findRestaurantsByCompanyAndCityAndResName(Company company, String city, String resName);
}

package com.project.swp.repository;

import com.project.swp.entity.Company;
import com.project.swp.entity.Order;
import com.project.swp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {


    // Customer //
    Optional<Restaurant> findRestaurantsByResID(int resId);
    public List<Restaurant> findTop6ByOrderByRatingPointDesc();

    @Query("select DISTINCT r.city from Restaurant r")
    public List<String> findDistinctCity();

    @Query("select distinct r.categoryRes from Restaurant r")
    public List<String> findCategoryRest();

    public List<Restaurant> findRestaurantsByCompanyAndCityContainingIgnoreCaseAndAndResNameContainingIgnoreCaseAndCategoryResContainsIgnoreCase(Company company, String city, String resName, String category);

    public List<Restaurant> findRestaurantsByCityContainingIgnoreCaseAndAndResNameContainingIgnoreCaseAndCategoryResContainsIgnoreCase(String city, String resName, String category);


    // Manager //

    Restaurant findOneByResID(int id);


    // Admin //

    List<Restaurant> findByCompany_CompanyID(int companyID);

}

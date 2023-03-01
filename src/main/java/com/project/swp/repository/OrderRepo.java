package com.project.swp.repository;

import com.project.swp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    // Manager //
    List<Order> findAllByResId();

}

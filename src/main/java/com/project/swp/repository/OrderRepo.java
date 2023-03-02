package com.project.swp.repository;

import com.project.swp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    // Manager //
    List<Order> findByTable_TableId_Restaurant_ResID(int resID);

    Order findByOrderId(int id);

    Order deleteByOrderId(int id);

}

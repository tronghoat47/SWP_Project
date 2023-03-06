package com.project.swp.repository;

import com.project.swp.entity.Menu;
import com.project.swp.entity.Order;
import com.project.swp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    Optional<Order> findOrderByOrderId(int orderID);

    List<Order> findOrdersByTable_TableId_Restaurant_ResID(int resID);
}
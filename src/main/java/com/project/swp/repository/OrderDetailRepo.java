package com.project.swp.repository;

import com.project.swp.entity.Order;
import com.project.swp.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepo extends CrudRepository<OrderDetail, Integer> {

}

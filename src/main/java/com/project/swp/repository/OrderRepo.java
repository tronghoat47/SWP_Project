package com.project.swp.repository;

import com.project.swp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    // Manager //
    List<Order> findByTable_TableId_Restaurant_ResID(int resID);

    Order findByOrderId(int id);

    Order deleteByOrderId(int id);

    List<Order> findByCustomer_CusIDOrderByOrderStatusDesc(int  cusID);

    @Query("select max (o.orderId) from Order o")
    int getOrderIdNLastest();

    @Modifying
    @Query("Update Order o set o.table.tableId.restaurant.resID = :resID where o.orderId = :orderID")
    void setResID(@Param("resID") int resID, @Param("orderID") int orderId);

}

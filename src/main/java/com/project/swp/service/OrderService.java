package com.project.swp.service;

import com.project.swp.entity.Order;
import com.project.swp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> ListOrder(){return orderRepo.findAll();}

    public void save(Order order) {
        orderRepo.save(order);
    }

    public Order getById(int id) {
        return orderRepo.findByOrderId(id);
    }

    public Order deleteById(int id){
        return orderRepo.deleteByOrderId(id);
    }

    public List<Order> getListOrderByCustomer(int  cusID) {
        return orderRepo.findByCustomer_CusIDOrderByOrderStatusDesc(cusID);
    }

//    @Transactional
//    public void setResID(int resID) {
//        orderRepo.setResID(resID, orderRepo.getOrderIdNLastest());
//
//    }

    // Manger // ==========================================================================================

    // Get Order by id //
    public Order getOrderById(int id) {
        return orderRepo.findByOrderId(id);
    }

}

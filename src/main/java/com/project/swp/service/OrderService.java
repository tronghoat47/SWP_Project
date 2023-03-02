package com.project.swp.service;

import com.project.swp.entity.Order;
import com.project.swp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Order getById(int id) throws Exception {
        return orderRepo.findByOrderId(id);
    }

    public Order deleteById(int id) throws Exception {
        return orderRepo.deleteByOrderId(id);
    }


}

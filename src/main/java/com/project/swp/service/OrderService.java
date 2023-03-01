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

    public Order getId(Integer id) throws Exception {
        Optional<Order> orderOptional = orderRepo.findById(id);
        try{
            if(orderOptional.isPresent()){
                return orderOptional.get();
            }
        }catch (Exception ex){
            throw new Exception("Not found order by id:" +id);
        }
        return null;
    }

    public Order deleteById(Integer id) throws Exception {
        Optional<Order> result = orderRepo.findById(id);
        try{
            if(result.isPresent() || result != null){
                orderRepo.deleteById(id);
            }
        }catch (Exception ex){
            throw new Exception("Could not found order with id: " + id);
        }
        return null;
    }



}

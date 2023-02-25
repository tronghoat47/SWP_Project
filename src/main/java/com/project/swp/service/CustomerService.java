package com.project.swp.service;

import com.project.swp.entity.Customer;
import com.project.swp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService{

    @Autowired
    private CustomerRepo customerRepo;

    public Customer authenticate(String username, String password){

        Customer customer = customerRepo.findOneByUserName(username).orElse(null);

        return (customer != null && customer.getPassword().equals(password)) ? customer : null;
    }

    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCus(String cusName){
        return customerRepo.findDistinctByCusName(cusName);
    }

}

package com.project.swp.service;

import com.project.swp.entity.Customer;
import com.project.swp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer authenticate(String username, String password){
        Customer customer = customerRepo.findFirstByUserName(username).orElse(null);
        return (customer != null && customer.getPassword().equals(password)) ? customer : null;
    }

    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public  Customer findByEmail(Customer customer){
        return customerRepo.findOneByEmail(customer.getEmail()).orElse(null);
    }

    public Customer findByUsername(String username){
        return customerRepo.findFirstByUserName(username).orElse(null);
    }

    public Customer findByCusID(int cusID){
        return customerRepo.findByCusID(cusID).orElse(null);
    }

    @Transactional
    public  void customerUpdateAndAdd(Customer customer) {
        customerRepo.save(customer);
    }
}

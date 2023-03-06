package com.project.swp.repository;

import com.project.swp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findFirstByUserName(String username);

    Optional<Customer> findOneByEmail(String email);

    Optional<Customer> findByCusID(int cusID);


}

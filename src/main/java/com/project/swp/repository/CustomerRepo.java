package com.project.swp.repository;

import com.project.swp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findOneByUserName(String username);

    Optional<Customer> findOneByEmail(String username);

}

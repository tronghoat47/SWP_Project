package com.project.swp.repository;

import com.project.swp.entity.Company;
import com.project.swp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
    Optional<List<Company>> findCompaniesByCompanyName(String username);

}

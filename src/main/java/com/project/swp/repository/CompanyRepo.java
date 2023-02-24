package com.project.swp.repository;

import com.project.swp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    public List<Company> findAll();

    public Company findCompanyByCompanyID(int CompanyID);
}

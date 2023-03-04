package com.project.swp.service;

import com.project.swp.entity.Company;
import com.project.swp.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerHomeService {
    @Autowired
    private CompanyRepo companyRepo;
    public List<Company> getListCompany() {
        return companyRepo.findAll();
    }
}

package com.project.swp.repository;

import com.project.swp.entity.Rate;
import com.project.swp.entity.RateId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepo extends JpaRepository<Rate, RateId> {

    public List<Rate> findAll();

}

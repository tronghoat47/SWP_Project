package com.project.swp.repository;

import com.project.swp.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Integer> {

        Optional<Menu> findById(Integer id);
}

package com.project.swp.service;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepo menuRepo;
    public List<Menu> getListHotFood() {
        return menuRepo.FindListHotFood();
    }

}

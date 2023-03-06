package com.project.swp.service;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.repository.CategoryMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMenuService {
    @Autowired
    private CategoryMenuRepo categoryMenuRepo;
    public CategoryMenu getCategoryMenuByCateID(int cateID){ return categoryMenuRepo.findCategoryMenuByCateID(cateID);}
    public List<CategoryMenu> getListCategory() {return categoryMenuRepo.findAll();}
}

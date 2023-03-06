package com.project.swp.service;

import com.project.swp.entity.CategoryMenu;
import com.project.swp.entity.Menu;
import com.project.swp.entity.Restaurant;
import com.project.swp.repository.CategoryMenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryMenuService {

    @Autowired
    private CategoryMenuRepo categoryMenuRepo;

    public List<CategoryMenu> listAllCategoryMenu(){
        return categoryMenuRepo.findAll();
    }


    public CategoryMenu getDetailCate(Integer id) {
        return categoryMenuRepo.findById(id).orElse(null);
    }

    public void save(CategoryMenu categoryMenu){
        categoryMenuRepo.save(categoryMenu);
    }

    public CategoryMenu get(Integer id) throws Exception {
        Optional<CategoryMenu> result = categoryMenuRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new Exception("Could not find category food with ID: " + id);
    }

    public CategoryMenu deleteById(Integer id) throws Exception {
        Optional<CategoryMenu> categoryMenuOptional = categoryMenuRepo.findById(id);
        if(categoryMenuOptional == null || categoryMenuOptional.isEmpty()){
            throw new Exception("Could not find and food with ID: " + id);
        }
        else{
            categoryMenuRepo.deleteById(id);
        }
        return null;
    }
}

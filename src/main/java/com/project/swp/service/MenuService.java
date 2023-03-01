package com.project.swp.service;

import com.project.swp.entity.Menu;
import com.project.swp.repository.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepo repo;

    public List<Menu> listAllFood(){
        return repo.findAll();
    }


    public void save(Menu menu){
        repo.save(menu);
    }

    public Menu get(Integer id) throws Exception {
        Optional<Menu> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new Exception("Could not find and food with ID: " + id);
    }

    public Menu deleteById(Integer id) throws Exception {
        Optional<Menu> menuOptional = repo.findById(id);
        if(menuOptional == null || menuOptional.isEmpty()){
            throw new Exception("Could not find and food with ID: " + id);
        }
        else{
            repo.deleteById(id);
        }
        return null;
    }

}

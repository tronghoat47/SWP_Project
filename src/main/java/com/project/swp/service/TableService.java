package com.project.swp.service;

import com.project.swp.entity.Tableq;
import com.project.swp.repository.TableqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    private TableqRepo tableqRepo;
    public Tableq getById(String id){
        return tableqRepo.findFirstByTableId(id);
    }

    public List<Tableq> getTableByResId(int resId){
        return tableqRepo.findByTableId_Restaurant_ResID(resId);
    }
}

package com.project.swp.service;

import com.project.swp.entity.Tableq;
import com.project.swp.repository.TableqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    @Autowired
    private TableqRepo tableqRepo;
    public Tableq getTableByResID(int resID) {
        return tableqRepo.findFirstByTableId_Restaurant_ResID(resID);
    }
}

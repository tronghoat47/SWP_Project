package com.project.swp.service;

import com.project.swp.entity.Tableq;
import com.project.swp.entity.TableqId;
import com.project.swp.repository.TableqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {
    @Autowired
    private TableqRepo tableqRepo;

    public List<Tableq> listAllTable(){
        return  tableqRepo.findAll();
    }

    public void save(Tableq tableq){
        tableqRepo.save(tableq);
    }


    public Tableq getTableID(String id) throws Exception {
        Optional<Tableq> result = tableqRepo.findByTableId(id);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new Exception("Not Found table with id");
        }
    }

    public Tableq deleteTableByID(TableqId tableqId) throws Exception {
        Optional<Tableq> getTableID = tableqRepo.findById(tableqId);
        if(!getTableID.isEmpty() || getTableID != null){
            tableqRepo.deleteById(tableqId);
        }else{
            throw new Exception("Not Found table with id");
        }
        return null;
    }


}

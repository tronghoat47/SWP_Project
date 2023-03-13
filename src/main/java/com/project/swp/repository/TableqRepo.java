package com.project.swp.repository;

import com.project.swp.entity.Tableq;
import com.project.swp.entity.TableqId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableqRepo extends JpaRepository<Tableq, TableqId> {

    Tableq findFirstByTableId(String tableId);

    List<Tableq> findByTableId_Restaurant_ResID(int resId);
}

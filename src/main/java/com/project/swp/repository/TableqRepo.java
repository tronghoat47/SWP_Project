package com.project.swp.repository;

import com.project.swp.entity.Tableq;
import com.project.swp.entity.TableqId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableqRepo extends JpaRepository<Tableq, TableqId> {
    Tableq findFirstByTableId_Restaurant_ResID(int redId);
}

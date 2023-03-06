package com.project.swp.repository;

import com.project.swp.entity.Tableq;
import com.project.swp.entity.TableqId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableqRepo extends JpaRepository<Tableq, TableqId> {

    Optional<Tableq> findByTableId(String tableID);
}

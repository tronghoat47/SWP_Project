package com.project.swp.repository;

import com.project.swp.entity.Invoice;
import com.project.swp.entity.InvoiceID;
import com.project.swp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceRepo extends CrudRepository<Invoice, InvoiceID> {
    List<Invoice> findAll();
}

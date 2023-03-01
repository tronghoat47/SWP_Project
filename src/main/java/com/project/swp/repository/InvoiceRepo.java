package com.project.swp.repository;

import com.project.swp.entity.Invoice;
import com.project.swp.entity.InvoiceID;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepo extends JpaRepository<Invoice, InvoiceID> {

}

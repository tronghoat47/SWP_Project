package com.project.swp.repository;

import com.project.swp.entity.Invoice;
import com.project.swp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

interface InvoiceRepo extends CrudRepository<Invoice, Integer> {

}

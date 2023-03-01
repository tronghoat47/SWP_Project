package com.project.swp.service;

import com.project.swp.entity.Invoice;
import com.project.swp.repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepo invoiceRepo;

    public double getRevenue(){
        List<Invoice> invoiceList = invoiceRepo.findAll();
        double totalRevenue = 0.0;
        for (Invoice invoice : invoiceList) {
            totalRevenue += invoice.getActualTotal();
        }
        return totalRevenue;
    }
}

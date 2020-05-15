package com.example.project.interfces;

import com.example.project.entity.Bill;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public interface BillService {

    List<Bill> findAll();

    Optional<Bill> findById(Integer id);

    List<Bill> findByBillDate(Timestamp billDate);

    void save(Bill bill);
}

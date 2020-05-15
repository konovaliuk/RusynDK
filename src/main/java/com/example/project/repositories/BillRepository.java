package com.example.project.repositories;

import com.example.project.entity.Bill;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface BillRepository extends CrudRepository<Bill, Integer> {
    List<Bill> findByBillDate(Timestamp billDate);
}

package com.example.project.spring_data;

import com.example.project.entity.Bill;
import com.example.project.interfces.BillService;
import com.example.project.repositories.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Repository("BillService")
@Transactional
@AllArgsConstructor


public class BillImpl implements BillService {
    private final BillRepository billRepository;

    public List<Bill> findAll() {
        return (List<Bill>) billRepository.findAll();
    }

    public Optional<Bill> findById(Integer id) {
        return billRepository.findById(id);
    }

    @Override
    public List<Bill> findByBillDate(Timestamp billDate) {
        return billRepository.findByBillDate(billDate);
    }

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }
}
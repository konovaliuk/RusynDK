package com.example.project.interfces;

import com.example.project.entity.*;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    List<Request> findAll();

    Optional<Request> findById(Integer id);

    void save(Request requests);

    void deleteById(Integer id);
}




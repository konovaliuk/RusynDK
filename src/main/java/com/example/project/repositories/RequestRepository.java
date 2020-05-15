package com.example.project.repositories;

import com.example.project.entity.Request;
import org.springframework.data.repository.CrudRepository;


public interface RequestRepository extends CrudRepository<Request, Integer> {
}


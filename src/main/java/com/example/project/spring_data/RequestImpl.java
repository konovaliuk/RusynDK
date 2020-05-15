package com.example.project.spring_data;

import com.example.project.entity.Request;
import com.example.project.interfces.RequestService;
import com.example.project.repositories.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository("RequestService")
@Transactional
@AllArgsConstructor


public class RequestImpl implements RequestService {
    private final RequestRepository requestRepository;

    public List<Request> findAll() {
        return (List<Request>) requestRepository.findAll();
    }

    public Optional<Request> findById(Integer id) {
        return requestRepository.findById(id);
    }

    @Override
    public void save(Request request) {
        requestRepository.save(request);
    }

    @Override
    public void deleteById(Integer id) {
        requestRepository.deleteById(id);
    }
}
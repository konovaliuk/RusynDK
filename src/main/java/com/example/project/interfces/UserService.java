package com.example.project.interfces;

import com.example.project.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> findAll();

    Optional<User> findByUserId(Integer id);

    Optional<User> findByLogin(String login);

    void save(User users);
}

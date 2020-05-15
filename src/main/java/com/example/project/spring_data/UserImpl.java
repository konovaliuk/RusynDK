package com.example.project.spring_data;

import com.example.project.entity.User;
import com.example.project.interfces.UserService;
import com.example.project.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("UsersRepository")
@Transactional
@AllArgsConstructor

public class UserImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void save(User users) {
        userRepository.save(users);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findByUserId(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}

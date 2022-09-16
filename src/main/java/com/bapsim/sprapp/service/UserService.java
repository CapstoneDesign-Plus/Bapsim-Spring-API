package com.bapsim.sprapp.service;

import com.bapsim.sprapp.model.User;
import com.bapsim.sprapp.model.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
//
//    public User findByEmail(String email) {
//
//        return this.userRepository.findById(email);
//    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}

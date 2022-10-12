package com.bapsim.sprapp.service;

import com.bapsim.sprapp.model.User;
import com.bapsim.sprapp.model.UserDTO;
import com.bapsim.sprapp.model.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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

    /**
     * Find user by email.
     * @param email identifier of the user finding.
     * @return the {@link Optional} Object that contains the user.
     * If no user found, returns {@link Optional#empty()}.
     */
    public User getUserByEmail(String email) {
        return userRepository.findById(email).orElse(null);
    }

    public UserDTO getUserDTOByEmail(String email) { return getUserByEmail(email).toUserDTO(); }

    public List<UserDTO> getUserPage(int pageNo, int interval) {
        return userRepository.findAll().stream()
                .skip((pageNo - 1) * interval)
                .limit(interval)
                .map(User::toUserDTO)
                .collect(Collectors.toList());
    }
    /**
     * Register (Sign up) user with given data.
     * @param username
     * @param password
     * @param email identifier of user
     * @return return {@code true} if successes, otherwise {@code false},
     */
    public boolean register(String username, String password, String email) {
        User user = new User(
                email,
                username,
                password,
                false,
                0,
                0,
                new ArrayList<>(),
                LocalDateTime.now()
        );

        userRepository.insert(user);
        return true;
    }

    /**
     * Find user by email and change username.
     * @param userEmail identifier of user
     * @param newUsername
     * @return return {@code true} if successes, otherwise {@code false}.
     */
    public boolean changeUsername(String userEmail, String newUsername) {
            User user = this.getUserByEmail(userEmail);
            if (user == null) return false;

            user.setUsername(newUsername);
            userRepository.save(user);
            return true;
    }

    /**
     * Find user by email and change password.
     * @param userEmail idnetifier of user
     * @param newPassword
     * @return return {@code true} if successed, otherwise {@code false}.
     */
    public boolean changePassword(String userEmail, String newPassword) {
        User user = this.getUserByEmail(userEmail);
        if (user == null) return false;

        user.setPassword(newPassword);
        userRepository.save(user);
        return true;
    }
}

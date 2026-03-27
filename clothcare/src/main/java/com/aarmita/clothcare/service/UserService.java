package com.aarmita.clothcare.service;

import com.aarmita.clothcare.entity.User;
import com.aarmita.clothcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElse(null);
    }

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateJoined(LocalDate.now());
        userRepository.save(user);
    }

    public void removeUserByUserId(int id) {
        userRepository.deleteById(id);
    }

    public boolean usernameExists(String username) {
        return userRepository.getUserByUsername(username).isPresent();
    }
}

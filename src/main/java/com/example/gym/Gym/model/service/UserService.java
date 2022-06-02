package com.example.gym.Gym.model.service;

import com.example.gym.Gym.model.entity.User;
import com.example.gym.Gym.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder cifrado;

    public User getByUserName(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    public User getById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createNewUser(User newUser) {
        newUser.setPassword(cifrado.encode(newUser.getPassword()));
        userRepository.save(newUser);
        return newUser;
    }

    public List<User> userList(){
        return userRepository.findAll();
    }
}
package com.gasnikovma.vk.services;

import com.gasnikovma.vk.models.dbEntity.UserTable;
import com.gasnikovma.vk.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;



@org.springframework.stereotype.Service
@AllArgsConstructor
@Slf4j
public class ServiceAddUser {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public boolean addUser(UserTable user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepository.findByName(user.getName()).isEmpty()) {
            userRepository.save(user);
            return true;
        }
        return false;

    }
}

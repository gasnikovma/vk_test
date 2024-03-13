package com.gasnikovma.vk.controllers;


import com.gasnikovma.vk.services.ServiceAddUser;
import com.gasnikovma.vk.models.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CreateUserController {

    private ServiceAddUser serviceImpl;

    @PostMapping("/new-user")
    public String addUser(@RequestBody UserEntity user) {

        return serviceImpl.addUser(user) ? "User is saved" : "User with this name already exists";
    }

}

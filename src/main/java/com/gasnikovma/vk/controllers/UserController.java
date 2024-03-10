package com.gasnikovma.vk.controllers;


import com.gasnikovma.vk.models.User;
import com.gasnikovma.vk.services.Service;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private Service serviceImpl;


    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USERS_VIEWER')")
    public Mono<String> getUsers() {
        return serviceImpl.getUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USERS_VIEWER')")
    public Mono<User> getUserById(@Max(10) @Min(1) @PathVariable int id) {
        return serviceImpl.getUser(id);
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USERS_EDITOR')")
    public Mono<User> setUser(@RequestBody User user) {
        return serviceImpl.setUser(user);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USERS_EDITOR')")
    public Mono<String> deleteUser(@PathVariable int id) {
        return serviceImpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USERS_EDITOR')")
    public Mono<User> updateUser(@Min(1) @Max(10) @PathVariable int id, @RequestBody User user) {
        return serviceImpl.updateUser(id, user);
    }

}

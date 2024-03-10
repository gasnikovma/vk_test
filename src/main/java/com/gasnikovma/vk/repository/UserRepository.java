package com.gasnikovma.vk.repository;

import com.gasnikovma.vk.models.dbentity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String username);
}

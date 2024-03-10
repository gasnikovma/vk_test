package com.gasnikovma.vk.repository;

import com.gasnikovma.vk.models.dbEntity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserTable,Long> {
    Optional<UserTable> findByName(String username);
}

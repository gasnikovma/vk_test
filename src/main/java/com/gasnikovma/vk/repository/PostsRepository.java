package com.gasnikovma.vk.repository;

import com.gasnikovma.vk.models.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostsRepository extends JpaRepository<PostEntity, Integer> {
   // Optional<PostEntity> findByPostId(int id);
}

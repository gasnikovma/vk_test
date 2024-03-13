package com.gasnikovma.vk.repository;

import com.gasnikovma.vk.models.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {
   // Optional<AlbumEntity> findByAlbumId(int id);


}

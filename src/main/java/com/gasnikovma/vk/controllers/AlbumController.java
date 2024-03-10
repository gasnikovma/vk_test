package com.gasnikovma.vk.controllers;

import com.gasnikovma.vk.models.Album;
import com.gasnikovma.vk.services.Service;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/albums")
public class AlbumController {

    private Service serviceImpl;

    @PreAuthorize("hasAuthority('ROLE_ALBUMS_VIEWER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping()

    public Mono<String> getAlbums() {
        return serviceImpl.getAlbums();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ALBUMS_VIEWER') or hasAuthority('ROLE_ADMIN')")
    public Mono<Album> getAlbumById(@Max(100) @Min(1) @PathVariable int id) {
        return serviceImpl.getAlbumById(id);
    }


    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_ALBUMS_EDITOR') or hasAuthority('ROLE_ADMIN')")
    public Mono<Album> setAlbum(@RequestBody Album album) {
        return serviceImpl.setAlbum(album);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ALBUMS_EDITOR') or hasAuthority('ROLE_ADMIN')")
    public Mono<String> deleteAlbum(@PathVariable int id) {
        return serviceImpl.deleteAlbum(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ALBUM_EDITOR') or hasAuthority('ROLE_ADMIN')")
    public Mono<Album> updateAlbum(@Min(1) @Max(100) @PathVariable int id, @RequestBody Album album) {
        return serviceImpl.updateAlbum(id, album);
    }
}

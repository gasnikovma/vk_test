package com.gasnikovma.vk.controllers;


import com.gasnikovma.vk.models.Post;
import com.gasnikovma.vk.services.Service;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostsController {
    private Service serviceImpl;

    @PreAuthorize("hasAuthority('ROLE_POSTS_VIEWER') or hasAuthority('ROLE_ADMIN')")
    @GetMapping()
    public Mono<String> getPosts() {
        return serviceImpl.getPosts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_POSTS_VIEWER') or hasAuthority('ROLE_ADMIN')")
    public Mono<Post> getPostById(@Max(100) @Min(1) @PathVariable int id) {
        return serviceImpl.getPost(id);
    }

    @GetMapping("/{id}/comments")
    @PreAuthorize("hasAuthority('ROLE_POSTS_VIEWER') or hasAuthority('ROLE_ADMIN')")
    public Mono<String> getComments(@Max(100) @Min(1) @PathVariable int id) {
        return serviceImpl.getComments(id);
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ROLE_POSTS_EDITOR') or hasAuthority('ROLE_ADMIN')")
    public Mono<Post> setPost(@RequestBody Post post) {
        return serviceImpl.setPost(post);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_POSTS_EDITOR') or hasAuthority('ROLE_ADMIN')")
    public Mono<String> deletePost(@PathVariable int id) {
        return serviceImpl.deletePost(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_POSTS_EDITOR') or hasAuthority('ROLE_ADMIN')")
    public Mono<Post> updatePost(@Min(1) @Max(100) @PathVariable int id, @RequestBody Post post) {
        return serviceImpl.updatePost(id, post);
    }

}

package com.gasnikovma.vk.services;


import com.gasnikovma.vk.clients.JsonPlaceHolderClient;
import com.gasnikovma.vk.models.Album;
import com.gasnikovma.vk.models.Post;
import com.gasnikovma.vk.models.User;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {


    private JsonPlaceHolderClient jsonPlaceHolderClient;


    public Mono<String> getUsers() {
        return jsonPlaceHolderClient.getUsers();
    }

    public Mono<User> getUser(int id) {
        return jsonPlaceHolderClient.getUser(id);
    }

    public Mono<User> setUser(User user) {
        return jsonPlaceHolderClient.setUser(user);
    }

    public Mono<String> deleteUser(int id) {
        return jsonPlaceHolderClient.deleteUser(id);
    }

    public Mono<User> updateUser(int id, User user) {
        return jsonPlaceHolderClient.updateUser(id, user);
    }

    public Mono<String> getComments(int id) {
        return jsonPlaceHolderClient.getComments(id);
    }

    public Mono<String> getPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    public Mono<Post> getPost(int id) {
        return jsonPlaceHolderClient.getPost(id);
    }

    public Mono<Post> setPost(Post post) {
        return jsonPlaceHolderClient.setPost(post);
    }

    public Mono<String> deletePost(int id) {
        return jsonPlaceHolderClient.deletePost(id);
    }

    public Mono<Post> updatePost(int id, Post post) {
        return jsonPlaceHolderClient.updatePost(id, post);
    }

    public Mono<String> getAlbums() {
        return jsonPlaceHolderClient.getAlbums();
    }

    public Mono<Album> getAlbumById(int id) {
        return jsonPlaceHolderClient.getAlbumById(id);
    }

    public Mono<Album> setAlbum(Album album) {
        return jsonPlaceHolderClient.setAlbum(album);
    }

    public Mono<String> deleteAlbum(int id) {
        return jsonPlaceHolderClient.deleteAlbum(id);
    }

    public Mono<Album> updateAlbum(int id, Album album) {
        return jsonPlaceHolderClient.updateAlbum(id,album);
    }
}

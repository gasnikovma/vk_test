package com.gasnikovma.vk.services;


import com.gasnikovma.vk.clients.JsonPlaceHolderClient;
import com.gasnikovma.vk.models.Album;
import com.gasnikovma.vk.models.HttpRequest;
import com.gasnikovma.vk.models.Post;
import com.gasnikovma.vk.models.User;
import com.gasnikovma.vk.models.entities.AlbumEntity;
import com.gasnikovma.vk.models.entities.PostEntity;
import com.gasnikovma.vk.repository.AlbumRepository;
import com.gasnikovma.vk.repository.PostsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
@Slf4j
@AllArgsConstructor
public class Service {


    private JsonPlaceHolderClient jsonPlaceHolderClient;
    private PostsRepository postsRepository;

    private AlbumRepository albumRepository;


    @Cacheable("users")
    public Mono<String> getUsers() {

        return jsonPlaceHolderClient.getUsers();
    }

    @Cacheable("user")
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

    @Cacheable("comments")
    public Mono<String> getComments(int id) {
        return jsonPlaceHolderClient.getComments(id);
    }

    @Cacheable("posts")
    public Mono<String> getPosts() {
        PostEntity postEntity = new PostEntity();
        postEntity.setAction(HttpRequest.GET.getRequest() + "_ALL");
        postsRepository.save(postEntity);
        return jsonPlaceHolderClient.getPosts();
    }

    @Cacheable("post")
    public Mono<Post> getPost(int id) {
        log.info("getting post by id: {}", id);
        PostEntity postEntity = new PostEntity();
        postEntity.setAction(HttpRequest.GET.getRequest());
        postEntity.setPostId(id);
        postsRepository.save(postEntity);
        return jsonPlaceHolderClient.getPost(id);
    }

    public Mono<Post> setPost(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(post.getId());
        postEntity.setAction(HttpRequest.POST.getRequest());
        postsRepository.save(postEntity);
        return jsonPlaceHolderClient.setPost(post);
    }


    public Mono<String> deletePost(int id) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(id);
        postEntity.setAction(HttpRequest.DELETE.getRequest());
        postsRepository.save(postEntity);
        return jsonPlaceHolderClient.deletePost(id);
    }

    public Mono<Post> updatePost(int id, Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(post.getId());
        postEntity.setAction(HttpRequest.PUT.getRequest());
        postsRepository.save(postEntity);
        return jsonPlaceHolderClient.updatePost(id, post);
    }

    @Cacheable("albums")
    public Mono<String> getAlbums() {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAction(HttpRequest.GET.getRequest() + "_ALL");
        albumRepository.save(albumEntity);
        return jsonPlaceHolderClient.getAlbums();
    }

    @Cacheable("album")
    public Mono<Album> getAlbumById(int id) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAction(HttpRequest.GET.getRequest());
        albumEntity.setAlbumId(id);
        albumRepository.save(albumEntity);
        return jsonPlaceHolderClient.getAlbumById(id);
    }

    public Mono<Album> setAlbum(Album album) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumId(album.getId());
        albumEntity.setAction(HttpRequest.POST.getRequest());
        albumRepository.save(albumEntity);
        return jsonPlaceHolderClient.setAlbum(album);
    }


    public Mono<String> deleteAlbum(int id) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumId(id);
        albumEntity.setAction(HttpRequest.DELETE.getRequest());
        albumRepository.save(albumEntity);
        return jsonPlaceHolderClient.deleteAlbum(id);
    }

    public Mono<Album> updateAlbum(int id, Album album) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setAlbumId(album.getId());
        albumEntity.setAction(HttpRequest.PUT.getRequest());
        albumRepository.save(albumEntity);
        return jsonPlaceHolderClient.updateAlbum(id, album);
    }
}

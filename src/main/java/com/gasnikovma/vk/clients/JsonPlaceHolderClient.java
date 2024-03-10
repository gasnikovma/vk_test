package com.gasnikovma.vk.clients;


import com.gasnikovma.vk.models.Album;
import com.gasnikovma.vk.models.Post;
import com.gasnikovma.vk.models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class JsonPlaceHolderClient {
    private final WebClient webClient;


    public JsonPlaceHolderClient(WebClient.Builder webClientBuilder, String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public Mono<String> getUsers() {
        return webClient.get().uri("/users").retrieve().bodyToMono(String.class);
    }

    public Mono<User> getUser(int id) {
        return webClient.get().uri("/users/{id}", id).retrieve().bodyToMono(User.class);
    }

    public Mono<User> setUser(User user) {
        return webClient.post()
                .uri("/users").
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class);
    }

    public Mono<String> deleteUser(int id) {
        return webClient.delete().uri("/users/{id}", id)
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return Mono.just("User deleted successfully");

                    } else {
                        return Mono.error(new RuntimeException("Failed to delete user"));
                    }
                }).onErrorResume(error -> Mono.just("Error: " + error.getMessage()))
                .defaultIfEmpty("Unknown error occurred");
    }

    public Mono<User> updateUser(int id, User user) {
        return webClient.put().uri("/users/{id}", id).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(user).retrieve().bodyToMono(User.class);
    }


    public Mono<String> getComments(int id) {
        return webClient.get().uri("/posts/{id}/comments", id).retrieve().bodyToMono(String.class);

    }

    public Mono<String> getPosts() {
        return webClient.get().uri("/posts").retrieve().bodyToMono(String.class);
    }

    public Mono<Post> getPost(int id) {
        return webClient.get().uri("/posts/{id}", id).retrieve().bodyToMono(Post.class);
    }

    public Mono<Post> setPost(Post post) {
        return webClient.post()
                .uri("/posts").
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(post)
                .retrieve()
                .bodyToMono(Post.class);
    }

    public Mono<String> deletePost(int id) {
        return webClient.delete().uri("/posts/{id}", id)
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return Mono.just("Post deleted successfully");

                    } else {
                        return Mono.error(new RuntimeException("Failed to delete post"));
                    }
                }).onErrorResume(error -> Mono.just("Error: " + error.getMessage()))
                .defaultIfEmpty("Unknown error occurred");
    }

    public Mono<Post> updatePost(int id, Post post) {
        return webClient.put().uri("/posts/{id}", id).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(post).retrieve().bodyToMono(Post.class);
    }


    public Mono<String> getAlbums() {
        return webClient.get().uri("/albums").retrieve().bodyToMono(String.class);
    }

    public Mono<Album> getAlbumById(int id) {
        return webClient.get().uri("/albums/{id}", id).retrieve().bodyToMono(Album.class);
    }

    public Mono<Album> setAlbum(Album album) {
        return webClient.post()
                .uri("/albums").
                header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(album)
                .retrieve()
                .bodyToMono(Album.class);

    }

    public Mono<String> deleteAlbum(int id) {
        return webClient.delete().uri("/albums/{id}", id)
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return Mono.just("Album deleted successfully");

                    } else {
                        return Mono.error(new RuntimeException("Failed to delete album"));
                    }
                }).onErrorResume(error -> Mono.just("Error: " + error.getMessage()))
                .defaultIfEmpty("Unknown error occurred");

    }

    public Mono<Album> updateAlbum(int id, Album album) {
        return webClient.put().uri("/posts/{id}", id).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(album).retrieve().bodyToMono(Album.class);

    }
}

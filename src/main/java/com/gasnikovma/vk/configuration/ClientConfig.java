package com.gasnikovma.vk.configuration;


import com.gasnikovma.vk.clients.JsonPlaceHolderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

    @Bean
    public JsonPlaceHolderClient jsonPlaceHolderClient(WebClient.Builder webClientBuilder,ApplicationConfig appConf) {
        return new JsonPlaceHolderClient(webClientBuilder,appConf.api().jsonPlaceHolderUrl());

    }


}

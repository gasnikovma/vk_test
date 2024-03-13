package com.gasnikovma.vk;

import com.gasnikovma.vk.clients.JsonPlaceHolderClient;
import com.gasnikovma.vk.models.User;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WebClientTest {
    private WireMockServer wireMockServer;
    private JsonPlaceHolderClient jsonPlaceHolderClient;

    @BeforeEach
    public void setup(){
        wireMockServer = new WireMockServer(options().dynamicPort());
        wireMockServer.start();
        WireMock.configureFor("localhost",wireMockServer.port());
        WebClient.Builder webClientBuilder = WebClient.builder();
        jsonPlaceHolderClient=new JsonPlaceHolderClient(webClientBuilder,wireMockServer.baseUrl());

    }

    @AfterEach
    public void tearDown(){
        wireMockServer.stop();
    }

    @Test
    public void getUsers(){
        String wireMockResponse = """
                {
                    "id": 7,
                    "name": "Kurtis Weissnat",
                    "username": "Elwyn.Skiles",
                    "email": "Telly.Hoeger@billy.biz",
                    "address": {
                        "street": "Rex Trail",
                        "suite": "Suite 280",
                        "city": "Howemouth",
                        "zipcode": "58804-1099",
                        "geo": {
                            "lat": "24.8918",
                            "lng": "21.8984"
                        }
                    },
                    "phone": "210.067.6132",
                    "website": "elvis.io",
                    "company": {
                        "name": "Johns Group",
                        "catchPhrase": "Configurable multimedia task-force",
                        "bs": "generate enterprise e-tailers"
                    }
                }
                """;
            wireMockServer.stubFor(get(urlEqualTo("/users/7")).willReturn(
                    aResponse().withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                            .withBody(wireMockResponse)));
        User user = jsonPlaceHolderClient.getUser(7).block();
        assertEquals(user.getPhone(),"210.067.6132");
        assertEquals(user.getEmail(),"Telly.Hoeger@billy.biz");


    }

}

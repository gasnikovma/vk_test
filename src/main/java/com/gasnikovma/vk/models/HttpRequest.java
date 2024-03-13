package com.gasnikovma.vk.models;

public enum HttpRequest {
    POST("POST"),
    PUT("PUT"),
    GET("GET"),
    DELETE("DELETE");
    private final String request;

    HttpRequest(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }

    @Override
    public String toString() {
        return request;
    }
}


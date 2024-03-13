package com.gasnikovma.vk.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;


@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
@EnableCaching

public record ApplicationConfig(
        Api api
) {
    public record Api(String jsonPlaceHolderUrl) {
    }
}


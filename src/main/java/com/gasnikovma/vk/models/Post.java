package com.gasnikovma.vk.models;

public record Post(
        int userId,
        int id,
        String title,
        String body
) {
}

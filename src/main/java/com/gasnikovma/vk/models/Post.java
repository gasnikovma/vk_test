package com.gasnikovma.vk.models;

import lombok.Data;

@Data
public class Post {
    int userId;
    int id;
    String title;
    String body;
}


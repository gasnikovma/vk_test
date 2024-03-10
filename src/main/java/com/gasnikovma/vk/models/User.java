package com.gasnikovma.vk.models;

import jakarta.validation.constraints.Max;

public record User(
        int id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
)  {
}

package com.gasnikovma.vk.models;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {
}

package com.dio.personapi.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Casa"),
    MOBILE("Celular"),
    COMMERCIAL("Comercial");

    private final String description;
}

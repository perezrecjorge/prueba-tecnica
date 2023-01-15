package com.mercadona.pruebatecnica.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@AllArgsConstructor
@Getter
public enum ProductoExceptionMessage implements ErrorMessage{

    PRODUCT_NOT_FOUND_ERROR(NOT_FOUND.value(), "E8-01", "Product not found", "Product with id %s not found."),
    PRODUCT_ALREADY_EXISTS_ERROR(UNPROCESSABLE_ENTITY.value(), "E8-02", "Product already exists", "Product %s already exist.");

    private final int httpCode;

    private final String internalCode;

    private final String reasonPhrase;

    private final String developerPhrase;
}

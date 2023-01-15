package com.mercadona.pruebatecnica.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@AllArgsConstructor
@Getter
public enum ProveedorExceptionMessage implements ErrorMessage{

    PROVEEDOR_NOT_FOUND_ERROR(NOT_FOUND.value(), "E8-01", "Proveedor not found", "Proveedor with id %s not found."),
    PROVEEDOR_ALREADY_EXISTS_ERROR(UNPROCESSABLE_ENTITY.value(), "E8-02", "Proveedor already exists", "Proveedor %s already exist.");

    private final int httpCode;

    private final String internalCode;

    private final String reasonPhrase;

    private final String developerPhrase;
}

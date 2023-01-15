package com.mercadona.pruebatecnica.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@AllArgsConstructor
@Getter
public enum DestinoExceptionMessage implements ErrorMessage{

    DESTINO_NOT_FOUND_ERROR(NOT_FOUND.value(), "E8-01", "Destino not found", "Destino with id %s not found."),
    DESTINO_CODE_NOT_FOUND_ERROR(NOT_FOUND.value(), "E8-02", "Destino not found", "Destino with codigo %s not found."),
    DESTINO_ALREADY_EXISTS_ERROR(UNPROCESSABLE_ENTITY.value(), "E8-03", "Destino already exists", "Destino %s already exist.");

    private final int httpCode;

    private final String internalCode;

    private final String reasonPhrase;

    private final String developerPhrase;
}

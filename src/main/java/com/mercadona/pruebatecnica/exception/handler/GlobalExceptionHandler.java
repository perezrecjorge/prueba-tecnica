package com.mercadona.pruebatecnica.exception.handler;

import com.mercadona.pruebatecnica.exception.AlreadyExistsException;
import com.mercadona.pruebatecnica.exception.InconsistentDataException;
import com.mercadona.pruebatecnica.exception.NotFoundException;
import com.mercadona.pruebatecnica.exception.ParametricNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends RestExceptionHandler {

    private final ApplicationEventPublisher eventPublisher;
    private final Environment environment;

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleGenericException(RuntimeException exception) {
        return buildCommonResponseEntity(exception, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(RuntimeException exception) {
        return buildCommonResponseEntity(exception, BAD_REQUEST);
    }

    @ExceptionHandler(value = {InconsistentDataException.class, AlreadyExistsException.class})
    protected ResponseEntity<Object> handleInconsistentDataException(RuntimeException exception) {
        return buildCommonResponseEntity(exception, UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NotFoundException.class, ParametricNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(RuntimeException exception) {
        return buildCommonResponseEntity(exception, NOT_FOUND);
    }

}

package com.mercadona.pruebatecnica.exception.handler;

import com.mercadona.pruebatecnica.exception.BaseException;
import com.mercadona.pruebatecnica.exception.model.ErrorResponse;
import com.mercadona.pruebatecnica.exception.model.SubError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public abstract class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildBindingErrorsResponseEntity(ex.getBindingResult(), status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildCommonResponseEntity(ex, status);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildBindingErrorsResponseEntity(ex.getBindingResult(), status);
    }

    protected ResponseEntity<Object> buildCommonResponseEntity(final Exception exception, final HttpStatus httpStatus) {
        final String internalCode = exception instanceof BaseException
                ? ((BaseException) exception).getInternalCode()
                : String.valueOf(httpStatus.value());
        final String message = Optional.ofNullable(exception.getMessage())
                .orElse(String.format("ERROR", exception.toString()));

        return buildErrorResponseEntity(httpStatus, internalCode, message, null);
    }

    protected ResponseEntity<Object> buildBindingErrorsResponseEntity(final BindingResult binding, final HttpStatus httpStatus) {
        final String internalCode = String.valueOf(httpStatus.value());
        final List<SubError> subErrors = binding.getFieldErrors().stream()
                .map(x -> SubError.builder().field(x.getField()).description(x.getDefaultMessage()).build())
                .collect(Collectors.toList());

        return buildErrorResponseEntity(httpStatus, internalCode, "There are several validation errors. More info in SubErrors field", subErrors);
    }

    private ResponseEntity<Object> buildErrorResponseEntity(final HttpStatus httpStatus, final String internalCode, final String message, final List<SubError> subErrors) {
        final ErrorResponse response = ErrorResponse.builder()
                .error(httpStatus.name())
                .detail(message)
                .status(httpStatus.value())
                .internalCode(internalCode)
                .timestamp(Instant.now().toEpochMilli())
                .subErrors(subErrors)
                .build();
        log.error(response.toString());
        return ResponseEntity.status(httpStatus.value())
                .body(response);
    }
}

package com.mercadona.pruebatecnica.exception;


import com.mercadona.pruebatecnica.exception.message.ErrorMessage;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

@Getter
public abstract class BaseException extends RuntimeException {

    private final transient List<Object> parameters;
    private final String developerPhrase;
    private final String internalCode;
    private final int httpCode;

    BaseException(final ErrorMessage errorMessage) {
        super(errorMessage.getReasonPhrase());
        this.parameters = List.of();
        this.internalCode = errorMessage.getInternalCode();
        this.developerPhrase = errorMessage.getDeveloperPhrase();
        this.httpCode = errorMessage.getHttpCode();
    }

    BaseException(final ErrorMessage errorMessage, final Object... parameters) {
        super(errorMessage.getReasonPhrase());
        this.developerPhrase = String.format(errorMessage.getDeveloperPhrase(), parameters);
        this.internalCode = errorMessage.getInternalCode();
        this.parameters = List.of(ArrayUtils.nullToEmpty(parameters));
        this.httpCode = errorMessage.getHttpCode();
    }
}

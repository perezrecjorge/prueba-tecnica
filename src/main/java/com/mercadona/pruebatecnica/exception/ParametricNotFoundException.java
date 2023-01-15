package com.mercadona.pruebatecnica.exception;

import com.mercadona.pruebatecnica.exception.message.ErrorMessage;

public class ParametricNotFoundException extends BaseException {

    public ParametricNotFoundException(ErrorMessage errorMessage, Object... parameters) {
        super(errorMessage, parameters);
    }
}

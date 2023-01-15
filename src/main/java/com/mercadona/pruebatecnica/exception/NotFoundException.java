package com.mercadona.pruebatecnica.exception;

import com.mercadona.pruebatecnica.exception.message.ErrorMessage;

public class NotFoundException extends BaseException {

    public NotFoundException(ErrorMessage errorMessage, Object... parameters) {
        super(errorMessage, parameters);
    }
}

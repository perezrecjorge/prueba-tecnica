package com.mercadona.pruebatecnica.exception;

import com.mercadona.pruebatecnica.exception.message.ErrorMessage;

public class AlreadyExistsException extends BaseException {

    public AlreadyExistsException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public AlreadyExistsException(ErrorMessage errorMessage, Object... parameters) {
        super(errorMessage, parameters);
    }

}

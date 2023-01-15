package com.mercadona.pruebatecnica.exception;

import com.mercadona.pruebatecnica.exception.message.ErrorMessage;

public class InconsistentDataException extends BaseException {

    public InconsistentDataException(ErrorMessage errorMessage) {
        super(errorMessage);
    }

    public InconsistentDataException(ErrorMessage errorMessage, Object... parameters) {
        super(errorMessage, parameters);
    }

}

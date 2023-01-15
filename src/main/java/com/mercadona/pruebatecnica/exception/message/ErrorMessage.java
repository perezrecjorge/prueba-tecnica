package com.mercadona.pruebatecnica.exception.message;

public interface ErrorMessage {

    int getHttpCode();

    String getInternalCode();

    String getReasonPhrase();

    String getDeveloperPhrase();

}

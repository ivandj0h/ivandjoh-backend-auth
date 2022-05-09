package com.ivandjoh.backendauth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IdAuthException extends RuntimeException {

    public IdAuthException(String message) {
        super(message);
    }
}

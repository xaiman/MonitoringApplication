package com.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestWithoutUserException extends RuntimeException {
    public RequestWithoutUserException() {
        super("Please specify user for getting history");
    }
}

package com.summergroup.portal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourcesAlreadyExistsException extends RuntimeException {
    public ResourcesAlreadyExistsException(String message) {
        super(message);
    }
}

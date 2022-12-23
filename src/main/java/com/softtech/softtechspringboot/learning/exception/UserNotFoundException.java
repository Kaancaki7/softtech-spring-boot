package com.softtech.softtechspringboot.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  //error ismini ve error kodunu 404 -500vb. gibi şeyleri değiştirmemizi sağlar.
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}

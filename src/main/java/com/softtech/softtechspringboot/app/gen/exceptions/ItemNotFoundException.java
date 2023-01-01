package com.softtech.softtechspringboot.app.gen.exceptions;

import com.softtech.softtechspringboot.app.cus.enums.CustomerErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(CustomerErrorMessage message) {

        super(message.getMessage());
    }
}

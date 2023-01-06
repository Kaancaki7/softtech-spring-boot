package com.softtech.softtechspringboot.app.gen.exceptions;

import com.softtech.softtechspringboot.app.cus.enums.CustomerErrorMessage;
import com.softtech.softtechspringboot.app.gen.enums.BaseErrorMessage;
import com.softtech.softtechspringboot.app.gen.enums.GenErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(BaseErrorMessage message) {

        super(message.getMessage());
    }
}

package com.softtech.softtechspringboot.app.cus.enums;

import com.softtech.softtechspringboot.app.gen.enums.BaseErrorMessage;

public enum CustomerErrorMessage implements BaseErrorMessage {

    CUSTOMER_ERROR_MESSAGE("Customer Not Found!"),
    ;

    private String message;
    CustomerErrorMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}

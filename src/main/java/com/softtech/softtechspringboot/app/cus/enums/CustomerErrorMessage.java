package com.softtech.softtechspringboot.app.cus.enums;

public enum CustomerErrorMessage {

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

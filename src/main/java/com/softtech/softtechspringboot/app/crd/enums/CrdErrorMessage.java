package com.softtech.softtechspringboot.app.crd.enums;

import com.softtech.softtechspringboot.app.gen.enums.BaseErrorMessage;

public enum CrdErrorMessage implements BaseErrorMessage {

    INVALID_CREDIT_CARD("Invalid credit card!"),
    INSUFFICIENT_CREDIT_CARD_LIMIT("Insufficient credit card limit!")
    ;

    private String message;
    CrdErrorMessage(String message) {

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

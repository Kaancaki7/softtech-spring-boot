package com.softtech.softtechspringboot.app.acc.enums;

import com.softtech.softtechspringboot.app.gen.enums.BaseErrorMessage;

public enum AccErrorMessage implements BaseErrorMessage {

    INSUFFICIENT_BALANCE("Insufficient balance!"),
    ;

    private String message;
    AccErrorMessage(String message) {

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

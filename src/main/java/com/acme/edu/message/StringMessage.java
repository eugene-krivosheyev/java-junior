package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class StringMessage extends Message{
    private final String message;

    public StringMessage(String message) {
        typeCodeEnum = TypeCodeEnum.STRING;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

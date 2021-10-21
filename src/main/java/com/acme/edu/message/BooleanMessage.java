package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class BooleanMessage extends Message{
    private final boolean message;

    public BooleanMessage(boolean message) {
        typeCodeEnum = TypeCodeEnum.BOOLEAN;
        this.message = message;
    }

    public boolean getMessage() {
        return message;
    }
}

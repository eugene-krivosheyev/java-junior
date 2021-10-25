package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class ReferenceMessage extends Message {
    private final Object message;

    public ReferenceMessage(Object message) {
        typeCodeEnum = TypeCodeEnum.NONE;
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }
}

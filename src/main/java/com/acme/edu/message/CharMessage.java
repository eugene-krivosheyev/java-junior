package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class CharMessage extends Message{
    private final char message;

    public CharMessage(char message) {
        typeCodeEnum = TypeCodeEnum.CHAR;
        this.message = message;
    }

    public char getMessage() {
        return message;
    }
}

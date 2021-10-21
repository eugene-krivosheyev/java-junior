package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class IntMessage extends Message{
    private final int message;

    public IntMessage(int message) {
        typeCodeEnum = TypeCodeEnum.INTEGER;
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}

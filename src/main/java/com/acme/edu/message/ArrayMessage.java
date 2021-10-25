package com.acme.edu.message;

import com.acme.edu.TypeCodeEnum;

public class ArrayMessage extends Message {
    private final int[] message;

    public ArrayMessage(int[] message) {
        typeCodeEnum = TypeCodeEnum.ARRAY_INT;
        this.message = message;
    }

    public int[] getMessage() {
        return message;
    }
}

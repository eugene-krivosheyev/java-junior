package com.acme.edu.message;

public class ByteMessage extends IntMessage{

    public ByteMessage(long number) {
        super(number);
        maxLimit = Byte.MAX_VALUE;
        minLimit = Byte.MIN_VALUE;
    }
}

package com.acme.edu.ooad.message;

public class ByteMessage extends NumericMessage {
    public ByteMessage(int value) {
        super(value);
    }

    protected int getThresholdMinValue() {return Byte.MIN_VALUE;}
    protected int getThresholdMaxValue() {return Byte.MAX_VALUE;}
}

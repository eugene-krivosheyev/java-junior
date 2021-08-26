package com.acme.edu.ooad.message;

public class IntegerMessage extends NumericMessage {
    public IntegerMessage(int value) {
        super(value);
    }

    protected int getThresholdMinValue() {return Integer.MIN_VALUE;}
    protected int getThresholdMaxValue() {return Integer.MAX_VALUE;}

}

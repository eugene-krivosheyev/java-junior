package com.acme.edu;

import java.lang.reflect.Type;

public class NumberMessage extends LogMessage {
    private String PREFIX = "primitive: ";

    private static long primitiveSum = 0;
    private PrimitiveNumber number;

    @Override
    public String get() {
        if (primitiveSum + number.getNumber() > number.getMAX_VALUE()) {
            long returnValue = primitiveSum;
            primitiveSum = number.getNumber();

            return PREFIX + Long.toString(returnValue);
        } else {
            primitiveSum = primitiveSum + number.getNumber();
            return "";
        }
    }

    NumberMessage(PrimitiveNumber number) {
        this.number = number;
    }

}

package com.acme.edu;

public class PrimitiveNumber {
    private Number number;
    private Number MAX_VALUE;

    PrimitiveNumber(int number)
    {
        this.number = number;
        MAX_VALUE = Integer.MAX_VALUE;
    }

    PrimitiveNumber(byte number)
    {
        this.number = number;
        MAX_VALUE = Byte.MAX_VALUE;
    }

    public long getMAX_VALUE() {
        return (long)MAX_VALUE;
    }

    public long getNumber() {
        return (long)number;
    }
}

package com.db.edu;

public class IntBuffer {
    private int sum = 0;
    private int flagThereIsInteger;

    void accumulate(int value) {
        flagThereIsInteger = 1;
        sum = sum + value;
    }

    int getSum() {
        return sum;
    }

    void bufferFlush() {
        sum = 0;
        flagThereIsInteger = 0;
    }
}

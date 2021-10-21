package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class IntTwoDimensionalArrayMessage extends IntArrayMessage {
    private final int[][] value;
    public IntTwoDimensionalArrayMessage(int[][] array) {
        super(null);
        value = array;
    }

    @Override
    public String getDecoratedString() {
        int sum = 0;
        for (int[] array: value) {
            sum += super.getSumOfArray(array);
        }
        return "matrix sum: " + sum;
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntTwoDimensionalArrayMessage;
    }

    @Override
    public void accumulate(Message message, Printer printer) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of IntTwoDimensionalArrayMessage");
        }
        printer.print(this);
        array = ((IntArrayMessage)message).array;
    }
}

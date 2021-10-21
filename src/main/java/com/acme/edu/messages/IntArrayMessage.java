package com.acme.edu.messages;

import com.acme.edu.common.Message;
import com.acme.edu.common.Printer;

public class IntArrayMessage implements Message {
    int[] array;

    public IntArrayMessage(int[] array) {
        this.array = array;
    }

    @Override
    public String getDecoratedString() {
        return "arrays's sum: " + getSumOfArray(array);
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntArrayMessage;
    }

    @Override
    public void accumulate(Message message, Printer printer) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of IntArrayMessage");
        }
        printer.print(this);
        array = ((IntArrayMessage)message).array;
    }
    private int getSumOfArray(int... array) {
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }
}

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
    public Message accumulate(Message message) {
        if (!isSameType(message)) {
            throw new IllegalArgumentException("Can not accumulate message which is not type of IntArrayMessage");
        }
        IntArrayMessage previousMessage = clone();
        array = ((IntArrayMessage)message).array;
        return previousMessage;
    }

    @Override
    public IntArrayMessage clone() {
        return new IntArrayMessage(array);
    }

    protected int getSumOfArray(int... array) {
        int sum = 0;
        for (int value: array) {
            sum += value;
        }
        return sum;
    }
}

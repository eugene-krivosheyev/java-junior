package com.acme.edu;

import com.acme.edu.message.Message;

public class IntStrategy implements Strategy {

    private int value;

    public int getValue() {
        return value;
    }

    public IntStrategy(int value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return message.getStrategy() instanceof IntStrategy;
    }
}

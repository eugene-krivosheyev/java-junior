package com.acme.edu.model.message;

import com.acme.edu.model.MessageType;

public class MessageWithSum extends Message {

    public MessageWithSum(MessageType type, String value) {
        super(type, value);
    }

    @Override
    public void addValue(String value) {
        setValue(String.valueOf(Integer.parseInt(getValue()) + Integer.parseInt(value)));
    }

    public boolean isSumLessThanMaxValue(int value, int maxValue) {
        return Long.parseLong(getValue()) + value <= maxValue;

    }

}

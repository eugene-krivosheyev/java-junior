package com.acme.edu.messages;

import com.acme.edu.common.Message;

public class IntMessage extends NumberMessage {

    private int value;

    public IntMessage(int message) {
        value = message;
    }

    @Override
    public String getDecoratedString() {
        return "primitive: " + value;
    }

    @Override
    public boolean isSameType(Message message) {
        return (message instanceof IntMessage);
    }

    @Override
    protected long getValue() {
        return value;
    }

    @Override
    protected void setValue(long value) {
        this.value = (int) value;
    }

    @Override
    protected long getMaxValue() {
        return Integer.MAX_VALUE;
    }

}

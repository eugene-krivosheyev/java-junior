package com.acme.edu.message;

public class IntMessage implements Message{
    private int value;
    private String prefix = "primitive: ";

    public IntMessage(int message) {
        value = message;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean needFlush(Message message) {
        long safe = value;
        safe += (int)message.getValue();
        return (safe > Integer.MAX_VALUE);
    }

    @Override
    public boolean isSameType(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public void updateAccumulator(Message message) {
        value += (int)message.getValue();
    }

    @Override
    public String toString() {
        return prefix + value;
    }
}

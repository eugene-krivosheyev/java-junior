package com.acme.edu;

public class IntMessage implements ILogMessage {
    private int value;
    private String PREFIX = "primitive: ";

    public IntMessage(int value_) {
        value = value_;
    }

    public boolean IsSameType(ILogMessage message) {
        return message instanceof IntMessage;
    }

    @Override
    public Object getValue(){
        return value;
    }

    @Override
    public void add(ILogMessage message) {
        value += (int)message.getValue();
    }

    @Override
    public String toString() {
        return PREFIX + value;
    }
}

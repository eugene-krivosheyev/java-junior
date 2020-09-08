package com.acme.edu;

import javax.swing.*;

public class StringMessage implements ILogMessage {
    private String value;
    private int xTimes = 0;
    private String PREFIX = "string: ";

    StringMessage(String value_) {
        value = value_;
    }

    public boolean IsSameType(ILogMessage message) {
        return message instanceof StringMessage;
    }

    @Override
    public Object getValue(){
        return value;
    }

    @Override
    public void add(ILogMessage message) {
        if (value.equals((String)message.getValue())) {
            xTimes += 1;
        } else {
            value += ((xTimes == 0) ? "" : "(x" + xTimes + ")");
            value += (String) message.getValue() + System.lineSeparator();
        }
    }

    @Override
    public String toString() {
        return PREFIX + value;
    }
}

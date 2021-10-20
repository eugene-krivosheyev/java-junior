package com.acme.edu.messages;

import com.acme.edu.common.Message;

// TODO make more common NumberMessage class with getNumber method and overflow logic
public class IntMessage implements Message {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public IntMessage(int message) {
        value = message;
    }
    @Override
    public String getDecoratedString() {
        return "primitive: " + value;
    }

    @Override
    public void clear() {
        value = 0;
    }

}

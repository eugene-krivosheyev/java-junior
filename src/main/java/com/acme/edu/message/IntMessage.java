package com.acme.edu.message;

import com.acme.edu.decorator.LoggerDecorator;

public class IntMessage extends Message {
    private static final String TYPE_NAME = "primitive";
    private int value;

    public IntMessage(int message) {
        this.value = message;
        type = TYPE_NAME;
    }

    public int getValue() {
        return value;
    }


    @Override
    public Message accumulate(Message message) {
        IntMessage newMessage = (IntMessage) message;
        int newValue = value + newMessage.value;
        return new IntMessage(newValue);
    }

    @Override
    public String getFormattedMessage(LoggerDecorator decorator) {
        return decorator.decorate(this);
    }

    @Override
    public boolean canBeAccumulated(Message message) {
        return super.canBeAccumulated(message) && !isOverflow(((IntMessage) message).value);
    }

    private boolean isOverflow(int term){
        return (term > 0 && value > Integer.MAX_VALUE - term) ||
                (term < 0 && value < Integer.MIN_VALUE - term);
    }
}

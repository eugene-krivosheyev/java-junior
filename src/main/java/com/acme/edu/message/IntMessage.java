package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.Map;

public class IntMessage extends Message {
    private int message;

    public int getMessage() {
        return message;
    }

    public IntMessage(int message) {
        this.message = message;
    }

    @Override
    public Message accumulate(Message message) {
        return new IntMessage(this.message + ((IntMessage) message).getMessage());
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.INT));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof IntMessage && !isOverflow(this.message, ((IntMessage) message).message);
    }

    private boolean isOverflow(int val1, int val2) {
        return val1 > 0 ?
                Integer.MAX_VALUE - val1 < val2 :
                Integer.MIN_VALUE - val1 > val2;
    }
}

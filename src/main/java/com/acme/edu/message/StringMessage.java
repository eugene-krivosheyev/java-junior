package com.acme.edu.message;

import com.acme.edu.decorator.Decorator;

import java.util.Map;

public class StringMessage extends Message {
    private String message;
    private int countOfStrings;

    public String getMessage() {
        return message;
    }

    public int getCountOfStrings() {
        return countOfStrings;
    }

    public StringMessage(String message) {
        this(message, 1);
    }

    private StringMessage(String message, int countOfStrings) {
        this.message = message;
        this.countOfStrings = countOfStrings;
    }

    @Override
    public Message accumulate(Message message) {
        return new StringMessage(this.message, this.countOfStrings + ((StringMessage) message).getCountOfStrings());
    }

    @Override
    public String decorate(Map<MessageType, Decorator> decoratorMap) {
        return decorate(decoratorMap.get(MessageType.STRING));
    }

    @Override
    public boolean isAbleToAccumulate(Message message) {
        return message instanceof StringMessage && ((StringMessage) message).getMessage().equals(this.message);
    }
}

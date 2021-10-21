package com.acme.edu.message;

import com.acme.edu.Strategy;

public class Message {

    private final Strategy strategy;

    public Message(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public boolean isSameType(Message message) {
        return this.strategy.isSameType(message);
    }

}

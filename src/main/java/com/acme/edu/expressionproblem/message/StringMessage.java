package com.acme.edu.expressionproblem.message;

public class StringMessage implements Message {
    private String body;

    public StringMessage(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return body;
    }
}

package com.acme.edu.expressionproblem.message;

public class IntMessage implements Message {
    private int body;

    public IntMessage(int body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return Integer.toString(body);
    }
}

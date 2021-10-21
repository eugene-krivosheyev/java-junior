package com.acme.edu.message;

public class StringMessage implements Message {

    private String body;
    private int counter = 1;

    public StringMessage(String body) {
        this.body = body;
    }

    public void incrementCounter() {
        this.counter++;
    }

    public String getBody() {
        return body;
    }
}

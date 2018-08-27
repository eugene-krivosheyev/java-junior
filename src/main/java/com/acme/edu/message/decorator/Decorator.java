package com.acme.edu.message.decorator;

public abstract class Decorator {
    private String message;

    public abstract String getDecoratedMessage();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

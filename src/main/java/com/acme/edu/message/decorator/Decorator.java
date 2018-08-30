package com.acme.edu.message.decorator;

import com.acme.edu.loggerexceptions.LoggerDecoratorException;

public abstract class Decorator {
    private String message;

    public abstract String getDecoratedMessage() throws LoggerDecoratorException;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

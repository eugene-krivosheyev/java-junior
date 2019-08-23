package com.acme.edu.command;

import com.acme.edu.Decorator;

public class StringCommand implements Command {
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Decorator.decorate(message);
    }
}

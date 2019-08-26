package com.acme.edu.commands;

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

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof StringCommand;
    }

    @Override
    public StringCommand accumulate(Command other) {
        message += ((StringCommand) other).getMessage();
        return this;
    }

    public String getMessage() {
        return message;
    }
}

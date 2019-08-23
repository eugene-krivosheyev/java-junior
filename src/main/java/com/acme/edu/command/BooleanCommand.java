package com.acme.edu.command;

import com.acme.edu.Decorator;

public class BooleanCommand implements Command {
    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Decorator.decorate(message);
    }
}

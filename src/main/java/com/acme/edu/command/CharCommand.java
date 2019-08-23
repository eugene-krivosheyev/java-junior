package com.acme.edu.command;

import com.acme.edu.Decorator;

public class CharCommand implements Command {
    private char message;

    public CharCommand(char message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Decorator.decorate(message);
    }
}

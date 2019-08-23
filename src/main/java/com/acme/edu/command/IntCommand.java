package com.acme.edu.command;

import com.acme.edu.Decorator;

public class IntCommand implements Command {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Decorator.decorate(message);
    }
}

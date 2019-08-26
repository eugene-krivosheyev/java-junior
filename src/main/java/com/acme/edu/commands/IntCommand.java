package com.acme.edu.commands;

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

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public IntCommand accumulate(Command other) {
        message += ((IntCommand) other).getMessage();
        return this;
    }

    public int getMessage() {
        return message;
    }
}

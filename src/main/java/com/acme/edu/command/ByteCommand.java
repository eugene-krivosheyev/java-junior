package com.acme.edu.command;

import com.acme.edu.Decorator;

public class ByteCommand implements Command {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Decorator.decorate(message);
    }
}

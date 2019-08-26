package com.acme.edu.commands;

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

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof ByteCommand;
    }

    @Override
    public ByteCommand accumulate(Command other) {
        message += ((ByteCommand) other).getMessage();
        return this;
    }

    public byte getMessage() {
        return message;
    }
}

package com.acme.edu.commands;

public class ByteCommand implements PrimitiveCommand {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof ByteCommand;
    }

    @Override
    public ByteCommand accumulate(Command other) {
        message += ((ByteCommand) other).message;
        return this;
    }
}
package com.acme.edu.commands;

public class ByteCommand implements Command {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Command.PRIMITIVE_PREFIX + message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof ByteCommand;
    }

    @Override
    public ByteCommand accumulate(Command other) {
        if (other instanceof ByteCommand) {
            return new ByteCommand((byte) (this.message + ((ByteCommand) other).getMessage()));
        } else {
            throw new IllegalArgumentException("Can't accumulate ByteCommand with other Command subclass");
        }
    }

    @Override
    public Byte getMessage() {
        return message;
    }
}
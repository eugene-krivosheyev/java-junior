package com.acme.edu;

public class ByteCommand implements Command {
    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof ByteCommand;
    }

    @Override
    public Command accumulate(Command other) {
        return new ByteCommand((byte) (this.message + (byte)other.getMessage()));
    }

    @Override
    public String getDecorated() {
        return PRIMITIVE_PREFIX + this.message;
    }

    @Override
    public Object getMessage() {
        return message;
    }
}

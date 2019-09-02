package com.acme.edu.mylogger.commands;

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
    public boolean isOverflow() {
        if (message < 0) {
            throw new ArithmeticException();
        }
        return false;
    }

    @Override
    public Command accumulate(Command other) {
        try {
            (new ByteCommand((byte) ((byte)this.getMessage() + (byte)other.getMessage()))).isOverflow();
        } catch (ArithmeticException e) {
            throw new ArithmeticException("ByteOverflow");
        }
        return new ByteCommand((byte) ((byte)this.getMessage() + (byte)other.getMessage()));
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

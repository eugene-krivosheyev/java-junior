package com.acme.edu.command;

public class ByteCommand extends PrimitiveCommand {

    public byte message;

    public ByteCommand(byte message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "" + message;
    }

    @Override
    public String decorate() {
        return PRIMITIVE_PREFIX + message;
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof  ByteCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }

}

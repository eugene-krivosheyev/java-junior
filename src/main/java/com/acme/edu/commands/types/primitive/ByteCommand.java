package com.acme.edu.commands.types.primitive;

public class ByteCommand extends PrimitiveCommand {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }

    @Override
    public String getMessage() { return String.valueOf(message); }
}

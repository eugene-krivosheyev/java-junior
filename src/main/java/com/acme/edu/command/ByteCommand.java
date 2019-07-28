package com.acme.edu.command;

public class ByteCommand extends CommonCommand<Byte> {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public Byte getMessage() {
        return message;
    }

    @Override
    protected String concreteDecoration(boolean toDecorate) {
        String result = Byte.toString(message);
        if (toDecorate) {
            result = "primitive: " + result;
        }
        return result;
    }

    @Override
    protected String concreteAccumulation(Command previousCommand) {
        message += (byte) previousCommand.getMessage();
        return null;
    }
}

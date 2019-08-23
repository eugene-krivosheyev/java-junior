package com.acme.edu;

public class ByteCommand extends PrimitiveCommand {
    private final byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    public byte getMessage() {
        return message;
    }
}

package com.acme.edu.commands.types.primitive;

import com.acme.edu.commands.Command;

public class ByteCommand extends PrimitiveCommand implements Command<Byte> {
    private byte message;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }

    @Override
    public Byte getMessage() { return message; }
}

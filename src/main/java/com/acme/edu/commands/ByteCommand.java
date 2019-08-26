package com.acme.edu.commands;

/**
 * Created by kate-c on 23/08/2019.
 */
public class ByteCommand implements Command {
    private long message;
    private final long UP_LIMIT = Byte.MAX_VALUE;

    public ByteCommand(byte message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }

    @Override
    public Command accumulate(Command other) {
        ByteCommand addend = (ByteCommand) other;
        final byte sum = (byte)(this.message + addend.message);
        return new ByteCommand(sum);
    }

    @Override
    public boolean canAccumulateWith(Command other) {
        if (!(other instanceof ByteCommand)) return false;
        ByteCommand addend = (ByteCommand) other;
        return (this.message + addend.message) <= UP_LIMIT;
    }
}

package com.acme.edu.commands;

import java.util.LinkedList;
import java.util.List;

public class ByteCommand implements Command {
    private byte message;
    private List<Byte> buffer = new LinkedList<>();

    public ByteCommand(byte message) {
        this.message = message;
        this.buffer.add(message);
    }

    private ByteCommand(byte message, List<Byte> buffer) {
        this.message = message;
        this.buffer = buffer;
    }

    @Override
    public String getDecorated() {
        return Command.PRIMITIVE_PREFIX + getBufferSum();
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof ByteCommand;
    }

    @Override
    public ByteCommand accumulate(Command other) {
        if (other instanceof ByteCommand) {
            byte otherMessage = ((ByteCommand) other).getMessage();
            buffer.add(otherMessage);

            return new ByteCommand(otherMessage, buffer);
        } else {
            throw new IllegalArgumentException("Can't accumulate ByteCommand with other Command subclass");
        }
    }

    @Override
    public Byte getMessage() {
        return message;
    }

    private byte getBufferSum() {
        int sum = this.buffer.stream().mapToInt(Byte::intValue).sum();
        if (sum > Byte.MAX_VALUE) {
            throw new IllegalArgumentException("Overflow accumulation is not supported yet");
        }
        return (byte) sum;
    }
}
package com.acme.edu.commands;

import java.util.LinkedList;
import java.util.List;

public class IntCommand implements Command {
    private int message;
    private List<Integer> buffer = new LinkedList<>();

    public IntCommand(int message) {
        this.message = message;
        this.buffer.add(message);
    }

    private IntCommand(int message, List<Integer> buffer) {
        this.message = message;
        this.buffer = buffer;
    }

    @Override
    public String getDecorated() {
        return Command.PRIMITIVE_PREFIX + getBufferSum();
    }

    @Override
    public boolean isTypeEquals(Command other) {
        return other instanceof IntCommand;
    }

    @Override
    public IntCommand accumulate(Command other) {
        if (other instanceof IntCommand) {
            int otherMessage = ((IntCommand) other).getMessage();
            buffer.add(otherMessage);

            return new IntCommand(otherMessage, buffer);
        } else {
            throw new IllegalArgumentException("Can't accumulate IntCommand with other Command subclass");
        }
    }

    @Override
    public Integer getMessage() {
        return message;
    }

    private int getBufferSum() {
        long sum = this.buffer.stream().mapToLong(Integer::longValue).sum();
        if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Overflow accumulation is not supported yet");
        }
        return (int) sum;
    }
}

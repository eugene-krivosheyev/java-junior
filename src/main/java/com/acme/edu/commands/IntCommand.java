package com.acme.edu.commands;

/**
 * Created by kate-c on 23/08/2019.
 */
public class IntCommand implements Command {
    private final long message;
    private static final long UP_LIMIT = Integer.MAX_VALUE;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return "primitive: " + message;
    }

    @Override
    public Command accumulate(Command other) {
        IntCommand addend = (IntCommand) other;
        final int sum = (int)(this.message + addend.message);
        return new IntCommand(sum);
    }

    @Override
    public boolean canAccumulateWith(Command other) {
        if (!(other instanceof IntCommand)) return false;
        IntCommand addend = (IntCommand) other;
        return (this.message + addend.message) <= UP_LIMIT;
    }
}

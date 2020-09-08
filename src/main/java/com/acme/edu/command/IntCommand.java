package com.acme.edu.command;

public class IntCommand extends PrimitiveCommand {

    public int message;

    public IntCommand(int message) {
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
        return cmd instanceof IntCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }

}

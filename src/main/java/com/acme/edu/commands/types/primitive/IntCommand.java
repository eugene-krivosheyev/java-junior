package com.acme.edu.commands.types.primitive;

public class IntCommand extends PrimitiveCommand {
    private int message;

    public IntCommand(int message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }

    @Override
    public String getMessage() { return String.valueOf(message); }
}

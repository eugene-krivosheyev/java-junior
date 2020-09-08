package com.acme.edu.command;

public class BooleanCommand extends PrimitiveCommand {

    public boolean message;

    public BooleanCommand(boolean message) {
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
        return cmd instanceof BooleanCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }

}

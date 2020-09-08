package com.acme.edu.command;

public class ObjectCommand implements Command {

    public static String REFERENCE_PREFIX = "reference: ";

    Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    public String toString() {
        return message.toString();
    }

    public String decorate() {
        return message.toString();
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof ObjectCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }
}

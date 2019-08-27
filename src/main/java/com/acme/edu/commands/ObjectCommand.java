package com.acme.edu.commands;

public class ObjectCommand implements Command {
    private final Object value;

    public ObjectCommand(Object message) {
        value = message;
    }

    @Override
    public String decorate() {
        return "reference: " + value;
    }
}

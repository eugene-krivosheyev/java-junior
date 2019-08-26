package com.acme.edu.commands;

public class BoolCommand implements Command {
    private boolean value;

    public BoolCommand(boolean value) {
        this.value = value;
    }

    @Override
    public String decorate() {
        return "primitive: " + value;
    }
}

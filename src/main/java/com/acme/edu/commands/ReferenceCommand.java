package com.acme.edu.commands;

public class ReferenceCommand implements DecorateCommand {
    private String message;

    public ReferenceCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return "reference: " + message;
    }
}

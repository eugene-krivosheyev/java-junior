package com.acme.edu.commands;

public class CharCommand implements DecorateCommand {
    private String message;

    public CharCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return "char: " + message;
    }
}

package com.acme.edu.commands;

public class CharCommand implements Command {
    private char value;

    public CharCommand(char value) {
        this.value = value;
    }

    @Override
    public String decorate() {
        return "char: " + value;
    }
}

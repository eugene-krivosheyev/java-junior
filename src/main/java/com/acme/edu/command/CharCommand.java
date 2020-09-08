package com.acme.edu.command;

public class CharCommand implements Command {

    public static String CHAR_PREFIX = "char: ";

    public char message;

    public CharCommand(char message) {
            this.message = message;
    }
    @Override
    public String toString() {
        return "" + message;
    }

    @Override
    public String decorate() {
        return CHAR_PREFIX + message;
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof CharCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }
}

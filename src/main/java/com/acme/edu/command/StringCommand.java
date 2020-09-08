package com.acme.edu.command;

import com.acme.edu.command.Command;

public class StringCommand implements Command {

    public static String STRING_PREFIX = "string: ";

    public String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String decorate() {
        return STRING_PREFIX + message;
    }

    @Override
    public boolean isSameType(Command cmd) {
        return cmd instanceof StringCommand;
    }

    @Override
    public Command reduce(Command cmd) {
        return null;
    }

}

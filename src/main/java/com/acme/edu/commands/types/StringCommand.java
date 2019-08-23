package com.acme.edu.commands.types;

import com.acme.edu.commands.Command;

public class StringCommand implements Command {
    private static final String STRING_PREFIX = "string: ";
    private String message;

    public StringCommand(String message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return STRING_PREFIX + message;
    }

    @Override
    public String getMessage() { return message; }
}

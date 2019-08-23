package com.acme.edu.commands.types;

import com.acme.edu.commands.Command;

public class ReferenceCommand implements Command {
    private static final String REFERENCE_PREFIX = "reference: ";
    private Object message;

    public ReferenceCommand(Object message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return REFERENCE_PREFIX + message;
    }

    @Override
    public String getMessage() { return message.toString(); }
}

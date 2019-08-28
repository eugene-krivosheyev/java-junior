package com.acme.edu.commands.types;

import com.acme.edu.StateCommand;
import com.acme.edu.commands.Command;

public class ReferenceCommand implements Command<Object> {
    private static final String REFERENCE_PREFIX = "reference: ";
    private Object message;

    public ReferenceCommand(Object message) { this.message = message; }

    @Override
    public String decorate() {
        return REFERENCE_PREFIX + message;
    }

    @Override
    public Command<Object> accumulate(Command command) throws IllegalArgumentException {
        if (!(command instanceof ReferenceCommand))
            throw new IllegalArgumentException("Not a reference command!");
        return new ReferenceCommand(message);
    }

    @Override
    public Object getMessage() { return message; }

    @Override
    public StateCommand getState() { return StateCommand.NONE; }
}

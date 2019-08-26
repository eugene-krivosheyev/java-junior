package com.acme.edu.commands.types;

import com.acme.edu.buffer.BufferState;
import com.acme.edu.commands.Command;

public class ReferenceCommand implements Command<Object> {
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
    public Command<Object> accumulate(Command command) { return null; }

    @Override
    public Object getMessage() { return message; }

    @Override
    public BufferState getState() { return BufferState.NONE; }
}

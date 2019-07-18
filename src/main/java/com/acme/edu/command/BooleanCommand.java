package com.acme.edu.command;

import com.acme.edu.Type;

public class BooleanCommand implements Command {
    private boolean message ;
    private Type CURRENT_TYPE = Type.BOOLEAN;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() {
        return "primitive: " + String.valueOf(message);
    }

    public boolean getBooleanValue() {
        return message;
    }

    @Override
    public boolean accumulate(Command accumulator) {
        return false;
    }
}

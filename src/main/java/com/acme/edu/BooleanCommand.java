package com.acme.edu;

public class BooleanCommand {
    private boolean message ;
    private Type CURRENT_TYPE = Type.BOOLEAN;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(int value) {
        return "primitive: " + String.valueOf(message);
    }

    public boolean getBooleanValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        return true;
    }
}

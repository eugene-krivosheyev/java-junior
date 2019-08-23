package com.acme.edu;

public class BooleanCommand extends PrimitiveCommand {
    private final boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public boolean getMessage() {
        return message;
    }
}

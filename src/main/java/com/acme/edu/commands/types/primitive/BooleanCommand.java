package com.acme.edu.commands.types.primitive;

public class BooleanCommand extends PrimitiveCommand {
    private boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    @Override
    public String decorate() {
        return super.getPrimitivePrefix() + message;
    }


    @Override
    public String getMessage() { return String.valueOf(message); }
}

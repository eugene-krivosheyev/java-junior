package com.acme.edu.commands;

public class BooleanCommand extends PrimitiveCommand {
    private final boolean message;

    public BooleanCommand(boolean message) {
        this.message = message;
    }

    public String getStringMessage() {
        return String.valueOf(message);
    }

    public boolean getMessage() {
        return message;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof BooleanCommand;
    }

    @Override
    public void accumulate(Command command) {
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return true;
    }
}

package com.acme.edu.commands;

import com.acme.edu.Constants;

public class CharCommand implements Command {
    private final char message;

    public CharCommand(char message) {
        this.message = message;
    }

    public char getMessage() {
        return message;
    }

    @Override
    public String getDecorated() {
        return Constants.CHAR_PREFIX + message;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof CharCommand;
    }

    @Override
    public CharCommand accumulate(Command command) {
        return this;
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return true;
    }
}

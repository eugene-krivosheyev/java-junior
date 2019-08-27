package com.acme.edu.commands;

import com.acme.edu.Constants;

public class ObjectCommand implements Command {
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.OBJECT_PREFIX + message;
    }

    @Override
    public boolean isTypeEqual(Command command) {
        return command instanceof ObjectCommand;
    }

    @Override
    public ObjectCommand accumulate(Command command) {
        return this;
    }

    @Override
    public boolean isSaveRequired(Command command) {
        return true;
    }
}

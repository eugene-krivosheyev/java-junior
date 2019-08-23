package com.acme.edu;

public class ObjectCommand implements Command {
    private Object message;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    @Override
    public String getDecorated() {
        return Constants.OBJECT_PREFIX + message;
    }
}

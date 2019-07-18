package com.acme.edu;

public class ObjectCommand {
    private Object message ;
    private Type CURRENT_TYPE = Type.OBJECT;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(int value) {
        return "reference: " + message.toString();
    }

    public Object getObjectValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        return true;
    }
}

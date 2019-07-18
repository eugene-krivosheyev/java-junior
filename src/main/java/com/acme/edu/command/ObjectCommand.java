package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class ObjectCommand implements Command {
    private Object message ;
    private Type CURRENT_TYPE = Type.OBJECT;

    public ObjectCommand(Object message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() {
        return "reference: " + message.toString();
    }

    public Object getObjectValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        return true;
    }

    @Override
    public boolean accumulate(Command accumulator) {
        return false;
    }
}

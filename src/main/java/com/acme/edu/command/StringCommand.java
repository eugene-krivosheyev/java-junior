package com.acme.edu.command;

import com.acme.edu.Accumulator;
import com.acme.edu.Type;

public class StringCommand {
    private String message = "";
    private Type CURRENT_TYPE = Type.STRING;

    public StringCommand(String message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(int value) {
        if(value>1) {
            return message + " (x" + value + ")";
        } else {
            return message;
        }
    }

    public String getStringValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        return !message.equals(accumulator.getStrBuff());
    }
}

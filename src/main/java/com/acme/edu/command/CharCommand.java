package com.acme.edu.command;

import com.acme.edu.Type;

public class CharCommand implements Command {
    private char message;
    private Type CURRENT_TYPE = Type.CHAR;

    public CharCommand(char message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate() {
        return "char: " + String.valueOf(message);
    }

    public char getCharValue() {
        return message;
    }

    @Override
    public boolean accumulate(Command accumulator) {
        return false;
    }
}

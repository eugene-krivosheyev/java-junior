package com.acme.edu;

public class CharCommand {
    private char message;
    private Type CURRENT_TYPE = Type.CHAR;

    public CharCommand(char message) {
        this.message = message;
    }

    public Type getType() {
        return CURRENT_TYPE;
    }

    public String messageDecorate(int value) {
        return "char: " + String.valueOf(message);
    }

    public char getCharValue() {
        return message;
    }

    public boolean isOverflow(Accumulator accumulator) {
        return true;
    }
}

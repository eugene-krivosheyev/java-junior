package com.acme.edu.message;

public class CharacterMessage extends Message {

    private final char value;

    public CharacterMessage(char value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }

    @Override
    public void process(Message message) {
        System.out.println("Unreachable output ...");
    }

    @Override
    public String decorate() {
        return "char: " + value;
    }
}

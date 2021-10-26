package com.acme.edu.message;

public class CharacterMessage extends Message {

    private char value;

    public char getValue() {
        return value;
    }

    public CharacterMessage(char value) {
        this.value = value;
    }

    @Override
    public boolean isSameType(Message message) {
        return false;
    }

    @Override
    public void process(Message message) {

    }

    @Override
    public String decorate() {
        return null;
    }
}

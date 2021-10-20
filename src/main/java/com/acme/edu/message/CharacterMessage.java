package com.acme.edu.message;

public class CharacterMessage implements Message {

    private char value;

    public char getValue() {
        return value;
    }

    public CharacterMessage(char value) {
        this.value = value;
    }
}

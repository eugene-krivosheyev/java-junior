package com.db.education.app.message;

public class CharacterMessage implements Message {
    private char value;

    public CharacterMessage(char value) {
        this.value = value;
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public String toString() {
        return "char: " + value + System.lineSeparator();
    }
}

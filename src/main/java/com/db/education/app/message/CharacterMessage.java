package com.db.education.app.message;

public class CharacterMessage implements Message {

    private static final String TYPE = "CHAR";

    private char body;

    public CharacterMessage(char body) {
        this.body = body;
    }

    @Override
    public CharacterMessage accumulate(Message message) {
        return this;
    }

    @Override
    public String getType() {
        return this.TYPE;
    }

    @Override
    public String toString() {
        return "char: " + body + System.lineSeparator();
    }
}

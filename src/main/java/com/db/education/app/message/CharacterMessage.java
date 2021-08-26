package com.db.education.app.message;

public class CharacterMessage implements Message {
    private final MessageType type = MessageType.CHAR;
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

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public boolean typeEquals(Message otherMessage) {
        return this.type.equals(otherMessage.getType());
    }
}

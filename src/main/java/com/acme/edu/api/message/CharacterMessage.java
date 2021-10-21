package com.acme.edu.api.message;

public class CharacterMessage extends Message {
    public CharacterMessage(char value) {
        setPrefix("char: ");
        setValue(String.valueOf(value));
    }

    @Override
    public boolean typeEquals(Message message) {
        return message instanceof CharacterMessage;
    }
}

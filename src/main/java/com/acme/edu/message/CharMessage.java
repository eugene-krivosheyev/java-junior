package com.acme.edu.message;

public class CharMessage extends Message {

    private static final String CHAR_PREFIX = "char: ";

    public CharMessage() {
        super(Type.CHAR);
    }
}

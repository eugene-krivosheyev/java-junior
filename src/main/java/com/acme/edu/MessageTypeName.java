package com.acme.edu;

public enum MessageTypeName {
    INT("primitive"), BYTE("primitive"), CHAR("char"),
    BOOLEAN("primitive"), STRING("string"), OBJECT("reference"), INITIAL("");

    private final String decor;


    private MessageTypeName(String name) {
        this.decor = name;
    }

    public String decoratePrimitive(String message) {
        return this.decor + ": " + message;
    }
}

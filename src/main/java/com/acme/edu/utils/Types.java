package com.acme.edu.utils;

public enum Types {
    BYTE("primitive: "),
    INTEGER("primitive: "),
    CHAR("char: "),
    STRING("string: "),
    BOOLEAN("primitive: "),
    OBJECT("reference: ");


    private final String prefix;
    Types(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}

package com.db.edu.message;

public enum Prefix {
    PRIMITIVE_PREFIX("primitive: "),
    CHAR_PREFIX("char: "),
    STRING_PREFIX("string: "),
    OBJECT_PREFIX("reference: ");

    public final String body;

    Prefix(String message) {
        this.body = message;
    }
}

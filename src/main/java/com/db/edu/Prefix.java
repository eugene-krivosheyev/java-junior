package com.db.edu;

public enum Prefix {
    PRIMITIVE_PREFIX("primitive: "),
    CHAR_PREFIX("char: "),
    STRING_PREFIX("string: "),
    OBJECT_PREFIX("reference: ");

    private final String message;

    Prefix(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

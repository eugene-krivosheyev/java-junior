package com.acme.edu.messages;

public enum MessageType {
    INTEGER("primitive: "),
    BOOLEAN("primitive: "),
    BYTE("primitive: "),
    CHARACTER("char: "),
    STRING("string: "),
    OBJECT_REFERENCE("reference: "),
    ARRAY("primitives array: "),
    MATRIX("primitives matrix: ");

    private final String prefix;

    MessageType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}

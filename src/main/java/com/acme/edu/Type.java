package com.acme.edu;

public enum Type {
    PRIMITIVE("primitive: "),
    CHAR("char: "),
    STRING("string: "),
    REFERENCE("reference: ");

    public String value;

    Type(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}

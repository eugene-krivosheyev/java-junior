package com.db.edu;

public enum Prefix {
    PRIMITIVE("primitive: "),
    CHAR("char: "),
    STRING("string: "),
    REFERENCE("reference: ");

    public final String value;

    Prefix(String value) {
        this.value = value;
    }
}

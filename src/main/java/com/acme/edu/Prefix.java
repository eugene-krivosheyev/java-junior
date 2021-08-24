package com.acme.edu;

public enum Prefix {
    PRIMITIVE("primitive:"),
    STRING("string:"),
    CHAR("char:"),
    REFERENCE("reference:");

    public final String value;

    Prefix(String value) {
        this.value = value;
    }
}

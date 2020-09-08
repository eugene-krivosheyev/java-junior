package com.acme.edu.message;

public enum Prefix {
    PRIMITIVE("primitive: "),
    CHAR("char: "),
    STRING("string: "),
    REFERENCE("reference: "),
    ARRAY("primitives array: "),
    MATRIX("primitives matrix: ");

    private String value;

    Prefix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

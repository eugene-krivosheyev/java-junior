package com.acme.edu.data;

public enum MessagePrefix {

    PRIMITIVE_PREFIX("primitive: "),
    CHAR_PREFIX("char: "),
    STRING_PREFIX("string: "),
    REFERENCE_PREFIX("reference: "),
    ARRAY_PREFIX("primitives array: "),
    MATRIX_PREFIX("primitives matrix: {"),
    MATRIX_POSTFIX("}");

    private final String prefixString;

    MessagePrefix(String prefixString) {
        this.prefixString = prefixString;
    }

    public String getPrefixString() {
        return prefixString;
    }
}

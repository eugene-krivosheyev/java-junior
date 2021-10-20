package com.acme.edu.model;

public enum MessageType {
    INT_TYPE("primitive: "),
    STRING_TYPE("string: "),
    BYTE_TYPE("primitive: "),
    BOOLEAN_TYPE("primitive: "),
    CHAR_TYPE("char: "),
    OBJ_TYPE("reference: "),
    INT_ARRAY_TYPE("primitives array: "),
    MATRIX_TYPE("primitives matrix: "),
    STR_ARRAY_TYPE("strings array: ");
    private final String prefix;

    MessageType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }


}

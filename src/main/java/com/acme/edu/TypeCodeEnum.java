package com.acme.edu;

public enum TypeCodeEnum {
    STRING("string: "),
    BYTE("primitive: "),
    INTEGER("primitive: "),
    CHAR("char: "),
    OBJECT("reference: "),
    BOOLEAN("primitive: "),
    ARRAY_INT("primitives array: "),
    MATRIX_INT("primitives matrix: "),
    NONE("");

    private final String typeReference;

    TypeCodeEnum(String typeReference) {
        this.typeReference = typeReference;
    }

    public String getTypeReference() {
        return typeReference;
    }
}

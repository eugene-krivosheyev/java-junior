package com.acme.edu;

public enum Type {

    STRING(ConstantValues.STRING_NAME),
    INT(ConstantValues.PRIMITIVE_NAME),
    BYTE(ConstantValues.PRIMITIVE_NAME),
    BOOL(ConstantValues.PRIMITIVE_NAME),
    CHAR(ConstantValues.CHAR_NAME),
    REFERENCE(ConstantValues.REFERENCE_NAME),
    UNDEFINED(ConstantValues.UNDEFINED),
    PRIMITIVES_ARRAY(ConstantValues.PRIMITIVES_ARRAY_NAME),
    PRIMITIVES_MATRIX(ConstantValues.PRIMITIVES_MATRIX_NAME);

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static class ConstantValues {
        static final String PRIMITIVE_NAME = "primitive";
        static final String REFERENCE_NAME = "reference";
        static final String CHAR_NAME = "char";
        static final String STRING_NAME = "string";
        static final String UNDEFINED = "undefined";
        static final String PRIMITIVES_ARRAY_NAME = "primitives array";
        static final String PRIMITIVES_MATRIX_NAME = "primitives matrix";
    }
}

package com.acme.edu;


public enum LoggerType {
    PRIMITIVE("primitive: "), STRING("string: "), REFERENCE("reference: "), CHAR("char: "), ARRAY("primitives array: "),
    MATRIX("primitives matrix: "), MULTIMATRIX("primitives multimatrix: ");
    private String type;

    LoggerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

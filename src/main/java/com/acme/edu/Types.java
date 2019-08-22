package com.acme.edu;


public enum Types {
    PRIMITIVE("primitive: "), STRING("string: "), REFERENCE("reference: "), CHAR("char: "), ARRAY("primitive array: "),
    MATRIX("primitive matrix: "), MULTIMATRIX("primitive multumatrix: ");
    private String type;

    Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

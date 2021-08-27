package com.db.edu;

public enum Types {
    PREFIX_PRIMITIVE ("primitive"),
    PREFIX_CHAR ("char"),
    PREFIX_STRING ("string"),
    PREFIX_REFERENCE ("reference");

    private final String type;

    Types(String type) {
        this.type = type;
    }
}

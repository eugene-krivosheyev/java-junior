package com.acme.edu;

public class Decorator {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static final String PRIMITIVES_PREFIX = "primitives ";
    public static final String PR_ARRAY_PREFIX = PRIMITIVES_PREFIX + "array: ";
    public static final String PR_MATRIX_PREFIX = PRIMITIVES_PREFIX + "matrix: ";
    public static final String PR_MULTIMATRIX_PREFIX = PRIMITIVES_PREFIX + "multimatrix: ";

    public static String decorate(boolean message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorate(byte message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorate(int message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorate(char message) {
        return CHAR_PREFIX + message;
    }

    public static String decorate(String message) {
        return STRING_PREFIX + message;
    }

    public static String decorate(Object message) {
        return REFERENCE_PREFIX + message;
    }
}

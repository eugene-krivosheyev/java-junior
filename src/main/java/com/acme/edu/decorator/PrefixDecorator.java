package com.acme.edu.decorator;

import com.acme.edu.message.IntMessage;

public class PrefixDecorator extends Decorator {
    private static final String PRIMITIVE = "primitive: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    public String decorate(int message) {
        return PRIMITIVE + message;
    }
    public String decorate(String message) {
        return STRING + message;
    }
    public String decorate(char message) {
        return CHAR + message;
    }
    public String decorate(byte message) {
        return PRIMITIVE + message;
    }
    public String decorate(boolean message) {
        return PRIMITIVE + message;
    }
}

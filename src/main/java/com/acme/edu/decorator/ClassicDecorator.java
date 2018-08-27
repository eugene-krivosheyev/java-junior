package com.acme.edu.decorator;

public class ClassicDecorator extends DecoratorVisitor {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";

    @Override
    public String decorateInt(int message) {
        return PRIMITIVE + message;
    }

    @Override
    public String decorateByte(byte message) {
        return PRIMITIVE + message;
    }

    @Override
    public String decorateChar(char message) {
        return CHAR + message;
    }

    @Override
    public String decorateString(String message) {
        return STRING + message;
    }

    @Override
    public String decorateObject(Object message) {
        return REFERENCE + message;
    }

    @Override
    public String decorateBoolean(boolean message) {
        return PRIMITIVE + message;
    }
}

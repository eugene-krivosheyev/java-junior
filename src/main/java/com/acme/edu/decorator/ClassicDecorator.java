package com.acme.edu.decorator;

public class ClassicDecorator extends DecoratorVisitor {
    private static final String PRIMITIVE = "primitive: ";
    private static final String CHAR = "char: ";
    private static final String STRING = "string: ";
    private static final String REFERENCE = "reference: ";
    private static final String PRIMITIVES_ARRAY = "primitives array: ";
    private static final String PRIMITIVES_MATRIX = "primitives matrix: ";
    private String arrayToString(int[] array) {
        String[] stringArray = new String[array.length];
        for (int counter = 0; counter < array.length; counter++) {
            stringArray[counter] = Integer.toString(array[counter]);
        }
        String result = "{" + String.join(", ", stringArray) + "}";
        return result;
    }

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
    public String decorateString(String message, int counter) {
        String post = "";
        if (counter > 1) {
            post = " (x" + counter + ")";
        }
        return STRING + message + post;
    }

    @Override
    public String decorateObject(Object message) {
        return REFERENCE + message;
    }

    @Override
    public String decorateBoolean(boolean message) {
        return PRIMITIVE + message;
    }

    @Override
    public String decorateIntArray(int[] message) {
        return PRIMITIVES_ARRAY + arrayToString(message);
    }

    @Override
    public String decorateIntMatrix(int[][] message){
        String string = new String();
        for (int counter = 0; counter < message.length; counter++) {
                        string = string + arrayToString(message[counter]) + System.lineSeparator();
        }
        return PRIMITIVES_MATRIX + "{" +System.lineSeparator() + string + "}";
    }
}

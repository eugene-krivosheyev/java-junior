package com.acme.edu.MessageDecorator;

public class DefaultDecorator implements MessageDecorator {
    private String primitivePrefix = "primitive: ";
    private String charPrefix = "char: ";
    private String stringPrefix = "string: ";
    private String referencePrefix = "reference: ";
    private String arrayPrefix = "primitives array: ";
    private String matrixPrefix = "primitives matrix: {\n";
    private String matrixPostfix = "}";


    public String getDecoratedMessage(int message) {
        return (primitivePrefix + message);
    }

    public String getDecoratedMessage(byte message) {
        return (primitivePrefix + message);
    }

    public String getDecoratedMessage(char message) {
        return (charPrefix + message);
    }

    public String getDecoratedMessage(String message) {
        return (stringPrefix + message);
    }

    public String getDecoratedMessage(boolean message) {
        return (primitivePrefix + message);
    }

    public String getDecoratedMessage(int[] message) {
        return (arrayPrefix + getDecoratedMessageFromArray(message));
    }

    public String getDecoratedMessage(int[][] message) {
        String temporaryString = matrixPrefix;
        for (int[] innerArray: message) {
            temporaryString += getDecoratedMessageFromArray(innerArray);
            temporaryString += "\n";
        }
        temporaryString += matrixPostfix;
        return temporaryString;
    }

    public String getDecoratedMessage(Object message) {
        return (referencePrefix + message);
    }

    private String getDecoratedMessageFromArray(int[] message) {
        String temporaryString = "{";
        for (int i = 0; i < message.length; i++) {
            if (i>0) {
                temporaryString += ", ";
            }
            temporaryString += message[i];
        }
        temporaryString += "}";
        return temporaryString;
    }
}

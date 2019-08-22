package com.acme.edu;


import java.util.Arrays;
import java.util.stream.Stream;

import static com.acme.edu.LoggerType.*;

public class Decorator {
    static String decoratePrimitive(String message) {
        return PRIMITIVE.getType() + message;
    }

    static String decorateString(String message) {
        return STRING.getType() + message;
    }

    static String decorateReference(String message) {
        return REFERENCE.getType() + message;
    }

    static String decorateChar(String message) {
        return CHAR.getType() + message;
    }

    static String decorateArray(String message) {
        return ARRAY.getType() + message;
    }

    static String decorateMatrix(int[][] message) {
        StringBuilder finalMessage = new StringBuilder("{\n");
        for (int[] integers : message) {
            finalMessage.append(Arrays.toString(integers)).append("\n");

        }
        finalMessage.append("}");
        return MATRIX.getType() + finalMessage.toString().replace("[", "{").replace("]", "}");
    }

    static String decorateMultiMatrix(String message) {
        return MULTIMATRIX.getType() + message;
    }

    static String decorateStringArray(String[] messages) {
        return STRING.getType() + String.join("\n", messages);
    }

    static String decorateIntegerArray(Integer[] messages) {
        return PRIMITIVE.getType() + Stream.of(messages).reduce(0, Integer::sum).toString();
    }
}
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

    static String decorateArray(int[] message) {
        String finalMessage = Arrays.toString(message);
        return ARRAY.getType() + finalMessage.replace("[", "{").replace("]", "}");
    }

    private static String decorateArray2D(int[][] message) {
        StringBuilder finalMessage = new StringBuilder("{\n");
        for (int[] integers : message) {
            finalMessage.append(Arrays.toString(integers)).append("\n");
        }
        finalMessage.append("}");
        return finalMessage.toString();
    }

    static String decorateMatrix(int[][] message) {
        return MATRIX.getType() + decorateArray2D(message).replace("[", "{").replace("]", "}");
    }

    static String decorateMultiMatrix(int[][][][] message) {
        StringBuilder finalMessage = new StringBuilder("{\n");
        for(int[][][] array3d : message) {
            finalMessage.append("{\n");
            for (int[][] array2d : array3d) {
                finalMessage.append(decorateArray2D(array2d).replace("[", "{\n").replace("]", "\n}"));
            }
            finalMessage.append("\n}\n");
        }
        finalMessage.append("}");
        return MULTIMATRIX.getType() + finalMessage;
    }

    static String decorateStringArray(String[] messages) {
        return STRING.getType() + String.join("\n", messages);
    }

    static String decorateIntegerArray(Integer[] messages) {
        return PRIMITIVE.getType() + Stream.of(messages).reduce(0, Integer::sum).toString();
    }
}
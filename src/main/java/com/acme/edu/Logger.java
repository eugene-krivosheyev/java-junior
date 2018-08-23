package com.acme.edu;

import java.util.Stack;

public class Logger {
    private static final String PRIMITIVE = "primitive";
    private static final String PRIMITIVES_ARRAY = "primitives array";
    public static final String PRIMITIVES_MATRIX = "primitives matrix";
    private static final String CHAR = "char";
    private static final String STRING = "string";
    private static final String REFERENCE = "reference";

    private static Stack<Object> objectStack = new Stack<Object>();

    public static void flush() {

        Object currentElement = null;

        while (!objectStack.empty()) {
            currentElement = objectStack.pop();

            if (currentElement.getClass() == Integer.class || currentElement.getClass() == Byte.class) {
                save(PRIMITIVE, currentElement.toString());
            } else if (currentElement.getClass() == String.class) {
                int numberOfEncounters =countStringOccurrenciesInStack(currentElement);
                String resultString = currentElement.toString();
                if (numberOfEncounters > 1)
                    resultString = resultString + " (x" + numberOfEncounters + ")";
                save(STRING, resultString);
            }
        }
    }

    private static int countStringOccurrenciesInStack(Object currentElement)
    {
        int numberOfEncounters = 1;
        while (!objectStack.empty() && objectStack.peek().getClass() == String.class && objectStack.peek().toString().equals(currentElement.toString())) {
            objectStack.pop();
            numberOfEncounters++;
        }
        return numberOfEncounters;
    }
    public static void log(int message) {
        if (stackIsCleanedAsFilledWithNotType(Integer.class)) {
            objectStack.push(message);
            return;
        }

        int tempResult = Integer.valueOf(objectStack.pop().toString());
        if (tempResult + message >= tempResult) {
            objectStack.push(tempResult + message);
        } else {
            objectStack.push(Integer.MAX_VALUE);
            flush();
            int result = message - (Integer.MAX_VALUE - tempResult);
            objectStack.push(result);
        }
    }

    public static void log(byte message) {
        if (stackIsCleanedAsFilledWithNotType(Byte.class)) {
            objectStack.push(message);
            return;
        }

        byte tempResult = Byte.valueOf(objectStack.pop().toString());
        if ((byte) (tempResult + message) >= tempResult) {
            objectStack.push(tempResult + message);
        } else {
            objectStack.push(Byte.MAX_VALUE);
            flush();
            int result = message - (Byte.MAX_VALUE - tempResult);
            objectStack.push(result);
        }
    }

    public static void log(String message) {
        if (!stackIsNotEmptyAndContainsString()) {
            flush();
        }
        objectStack.push((message));

    }

    public static void log(int[] message) {
        save(PRIMITIVES_ARRAY, oneDimArrayAsString(message));
    }

    public static void log(int[][] message) {

        String[] arrayOfIntsAsString = new String[message.length];
        for (int i = 0; i < arrayOfIntsAsString.length; i++) {
            arrayOfIntsAsString[i] = oneDimArrayAsString(message[i]);
        }
        String joinedArraysAsStrings = String.join(System.lineSeparator(), arrayOfIntsAsString);
        String finalResult = "{" + System.lineSeparator() + joinedArraysAsStrings + System.lineSeparator() + "}";
        save(PRIMITIVES_MATRIX, finalResult);
    }

    public static void log(char message) {
        save(CHAR, Character.toString(message));
    }

    public static void log(boolean message) {
        save(PRIMITIVE, Boolean.toString(message));
    }


    public static void log(Object message) {
        save(REFERENCE, message.toString());
    }

    private static void save(String type, String message) {
        System.out.println(type + ": " + message);
    }

    private static boolean stackIsNotEmptyAndContainsString() {
        return (objectStack.empty() || objectStack.peek().getClass() == String.class);
    }

    private static boolean stackIsCleanedAsFilledWithNotType(Class type) {
        if (objectStack.empty()) {
            return true;
        }

        if (objectStack.peek().getClass() != Integer.class) {
            flush();
            return true;
        }

        return false;
    }

    private static String oneDimArrayAsString(int[] array) {
        if (array.length == 0) {
            return "{" + System.lineSeparator() + "}";
        }
        StringBuilder arrayAsString = new StringBuilder("{");
        for (int i = 0; i < array.length - 1; i++) {
            arrayAsString.append(array[i]);
            arrayAsString.append(", ");
        }
        arrayAsString.append(array[array.length - 1]);
        arrayAsString.append("}");
        return arrayAsString.toString();
    }
}

package com.acme.edu;

import java.util.Arrays;

import static java.lang.System.lineSeparator;

public class Logger {
    private static int accumulatedSum = 0;
    private static String accumulatedStr = "";
    private static String previousStr = "";
    private static int isPrimitiveCount = 0;
    private static int sameStringsAmount = 0;
    private static String prevTypeName = "";
    private static boolean isPrimitive = true;

    private static String decorator(String message, String typeName) {
        if (!isPrimitive) return message;
        switch (typeName) {
            case "int":
            case "byte":
            case "bool": {
                return "primitive: " + message;
            }
            case "char": {
                return "char: " + message;
            }
            case "string": {
                return "string: " + message;
            }
            default: {
                return "reference: " + message;
            }
        }
    }

    private static void typeSwitcher(String typeName) {
        isPrimitiveCount++;
        if (prevTypeName.equals(typeName)) return;
        switch (prevTypeName) {
            case "int":
            case "byte": {
                accumulatedStr += accumulatedSum + lineSeparator();
                accumulatedSum = 0;
                break;
            }
            case "string": {
                accumulatedStr += previousStr;
                if (sameStringsAmount > 1) {
                    accumulatedStr += " (x" + sameStringsAmount + ")";
                }
                accumulatedStr += lineSeparator();
                previousStr = "";
                sameStringsAmount = 0;
            }
            default:
        }
    }

    public static void log(int message) {
        typeSwitcher("int");
        prevTypeName = "int";
        if (message > 0) {
            if (accumulatedSum > Integer.MAX_VALUE - message) {
                accumulatedStr += accumulatedSum + lineSeparator();
                accumulatedSum = Integer.MAX_VALUE;
            } else {
                accumulatedSum += message;
            }
        } else {
            if (accumulatedSum < Integer.MIN_VALUE - message) {
                accumulatedStr += accumulatedSum + lineSeparator();
                accumulatedSum = Integer.MIN_VALUE;
            } else {
                accumulatedSum += message;
            }
        }
    }

    public static void log(byte message) {
        typeSwitcher("byte");
        prevTypeName = "byte";
        if (message > 0) {
            if (accumulatedSum > Byte.MAX_VALUE - message) {
                accumulatedStr += accumulatedSum + lineSeparator();
                accumulatedSum = Byte.MAX_VALUE;
            } else {
                accumulatedSum += message;
            }
        } else {
            if (accumulatedSum < Byte.MIN_VALUE - message) {
                accumulatedStr += accumulatedSum + lineSeparator();
                accumulatedSum = Byte.MIN_VALUE;
            } else {
                accumulatedSum += message;
            }
        }
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        typeSwitcher("string");
        prevTypeName = "string";
        if (previousStr.equals(message)) {
            sameStringsAmount++;
            return;
        }
        if (!previousStr.equals("")) {
            accumulatedStr += previousStr +
                    (sameStringsAmount > 1 ? " (x" + sameStringsAmount + ")" : "") +
                    lineSeparator();
        }
        previousStr = message;
        sameStringsAmount = 1;
    }

    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        if (message == null) {
            message = "null";
        }
        System.out.println("reference: " + message);
    }

    public static void log(int[] array) {
        System.out.println(("primitives array: " + String.join(lineSeparator(), Arrays.toString(array)))
                .replace('[', '{')
                .replace(']', '}'));
    }

    public static void log(String... params) {
        System.out.print(String.join(lineSeparator(), params));
    }

    public static void flush() {
        if (isPrimitiveCount > 1) {
            isPrimitive = false;
        }
        typeSwitcher("");
        System.out.print(decorator(accumulatedStr, prevTypeName));
        accumulatedStr = "";
        accumulatedSum = 0;
        previousStr = "";
        prevTypeName = "";
        isPrimitive = true;
        isPrimitiveCount = 0;
    }
}

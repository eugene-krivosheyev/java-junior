package com.acme.edu;

import java.util.Objects;

public class Logger {

    public static final String typePrimitive = "pimitive: ";
    public static final String typeChar = "char: ";
    public static final String typeString = "string: ";
    public static final String typeReference = "reference: ";

    enum TypeCode {
        STRING,
        BYTE,
        INTEGER,
        CHAR,
        OBJECT,
        BOOLEAN,
        INT2DARRAY,
        INTARRAY,
        NONE
    }

    private static TypeCode prevTypeCode = TypeCode.NONE;

    private static int similarStringCounter = 0;
    private static int integerSum = 0;
    private static int byteSum = 0;
    private static String prevString = null;

    public static void log(String... messages) {
        for (String message : messages) {
            log(message);
        }
    }

    public static void log(int... messages) {
        flushOnCondition(notSameTypeCode(TypeCode.INTARRAY));
        for (int message : messages) {
            log(message);
        }
        prevTypeCode = TypeCode.INTARRAY;
    }

    public static void log(int[]... messages) {
        flushOnCondition(notSameTypeCode(TypeCode.INT2DARRAY));
        for (int[] message : messages) {
            for (int element : message) {
                log(element);
            }
        }
        prevTypeCode = TypeCode.INT2DARRAY;
    }

    public static void log(String message) {
        flushOnCondition(notSameTypeCode(TypeCode.STRING));

        if (!Objects.equals(prevString, message) && prevString != null) {
            flush();
        }
        similarStringCounter++;
        prevString = (String)message;
        prevTypeCode = TypeCode.STRING;
    }

    public static void log(byte message) {
        flushOnCondition(notSameTypeCode(TypeCode.BYTE));
        byteSum = countSum(byteSum, (byte)message, Byte.MAX_VALUE, Byte.MIN_VALUE);
        prevTypeCode = TypeCode.BYTE;
    }

    public static void log(int message) {
        flushOnCondition(notSameTypeCode(TypeCode.INTEGER));
        integerSum = countSum(integerSum, (int)message, Integer.MAX_VALUE, Integer.MIN_VALUE);
        prevTypeCode = TypeCode.INTEGER;
    }

    public static void log(boolean message) {
        flushOnCondition(notSameTypeCode(TypeCode.BOOLEAN));
        printToConsole(typePrimitive + message);
        prevTypeCode = TypeCode.BOOLEAN;
    }

    public static void log(char message) {
        flushOnCondition(notSameTypeCode(TypeCode.CHAR));
        printToConsole(typeChar + message);
        prevTypeCode = TypeCode.CHAR;
    }

    public static void log(Object message) {
        flushOnCondition(notSameTypeCode(TypeCode.OBJECT));
        printToConsole(typeReference + message);
        prevTypeCode = TypeCode.OBJECT;
    }

    public static void flush() {
        switch (prevTypeCode) {
            case STRING: {
                if(similarStringCounter > 1) {
                    printToConsole(typeString + prevString + " (x" + similarStringCounter + ")");
                } else {
                    printToConsole(typeString + prevString);
                }
                prevString = null;
                similarStringCounter = 0;
                break;
            }
            case BYTE: {
                printToConsole(typePrimitive + byteSum);
                byteSum = 0;
                break;
            }
            case INTARRAY:
            case INT2DARRAY:
            case INTEGER: {
                printToConsole(typePrimitive + integerSum);
                integerSum = 0;
                break;
            }
            default: break;
        }
    }

    private static boolean notSameTypeCode (TypeCode typeCode) {
        if (prevTypeCode == TypeCode.NONE) {
            prevTypeCode = typeCode;
        }
        return typeCode != prevTypeCode;
    }

    private static void flushOnCondition(boolean notSameType) {
        if (notSameType) {
            flush();
        }
    }

    private static long checkOverflow(long result, int max, int min) {
        if (result > max) {
            return result - max;
        }
        if (result < min) {
            return result + min;
        }
        return result;
    }

    private static int countSum(int externalSum, int income, int max, int min) {
        long sum = (long)externalSum + (long)income;
        long result = checkOverflow(sum, max, min);

        if (result > sum) {
            printToConsole(Integer.toString(min));
        } else if (result < sum) {
            printToConsole(Integer.toString(max));
        }
        return (int)result;
    }

    private static void printToConsole(String message) {
        System.out.println(message);
    }
}

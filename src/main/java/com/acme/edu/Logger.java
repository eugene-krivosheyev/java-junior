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
        NONE
    }

    private static TypeCode prevTypeCode = TypeCode.NONE;

    private static int similarStringCounter = 0;
    private static int integerSum = 0;
    private static int byteSum = 0;
    private static String prevString = null;

    public static void log(Object... messages) {
        for (Object message : messages) {
            log(message);
        }
    }

    public static void log(Object message) {
        TypeCode typeCode = getTypeCode(message);

        if (prevTypeCode != TypeCode.NONE && typeCode != prevTypeCode) {
            flush();
        }

        switch (typeCode) {
            case STRING: {
                if (!Objects.equals(prevString, message) && prevString != null) {
                    flush();
                }
                similarStringCounter++;
                prevString = (String)message;
                break;
            }

            case BYTE: {
                byteSum = countSum(byteSum, (byte)message, Byte.MAX_VALUE, Byte.MIN_VALUE);
                break;
            }
            case INTEGER: {
                integerSum = countSum(integerSum, (int)message, Integer.MAX_VALUE, Integer.MIN_VALUE);
                break;
            }
            case BOOLEAN: {
                printToConsole(typePrimitive + message);
                break;
            }
            case CHAR: {
                printToConsole(typeChar + message);
                break;
            }
            case OBJECT: {
                printToConsole(typeReference + message);
                break;
            }
        }
        prevTypeCode = typeCode;
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
            case INTEGER: {
                printToConsole(typePrimitive + integerSum);
                integerSum = 0;
                break;
            }
            default: break;
        }
    }

    private static void printToConsole(String message) {
        System.out.println(message);
    }

    private static TypeCode getTypeCode(Object message) {
        if (message.getClass() == String.class) {
            return TypeCode.STRING;
        }
        if (message.getClass() == Byte.class) {
            return TypeCode.BYTE;
        }
        if (message.getClass() == Integer.class) {
            return TypeCode.INTEGER;
        }
        if (message.getClass() == Object.class) {
            return TypeCode.OBJECT;
        }
        if (message.getClass() == Boolean.class) {
            return TypeCode.BOOLEAN;
        }
        if (message.getClass() == Character.class) {
            return TypeCode.CHAR;
        }
        return TypeCode.NONE;
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
}

package com.acme.edu;

import java.util.Objects;

public class Logger {

    public static final String typePrimitive = "primitive: ";
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

    public static void log(Object message) {
        TypeCode typeCode = getTypeCode(message);

        if (prevTypeCode != TypeCode.NONE && typeCode != prevTypeCode) {
            flush();
        }

        switch (typeCode) {
            case STRING: {
                if (Objects.equals(prevString, message)) {
                    similarStringCounter++;
                } else if (prevString != null) {
                    flush();
                }
                prevString = (String) message;
                break;
            }
            case BYTE: {
                byteSum = countSum(byteSum, (byte) message, Byte.MAX_VALUE, Byte.MIN_VALUE);
                break;
            }
            case INTEGER: {
                integerSum = countSum(integerSum, (int) message, Integer.MAX_VALUE, Integer.MIN_VALUE);
                break;
            }
            default: {
                sendToSystemOut(getPrefixType(typeCode) + message);
            }
        }
        prevTypeCode = typeCode;
    }

    public static void flush() {
        switch (prevTypeCode) {
            case STRING: {
                similarStringCounter++;
                if (similarStringCounter > 1) {
                    sendToSystemOut(getPrefixType(prevTypeCode) + prevString + " (x" + similarStringCounter + ")");
                } else {
                    sendToSystemOut(getPrefixType(prevTypeCode) + prevString);
                }
                prevString = null;
                similarStringCounter = 0;
                break;
            }
            case BYTE: {
                sendToSystemOut(getPrefixType(prevTypeCode) + byteSum);
                byteSum = 0;
                break;
            }
            case INTEGER: {
                sendToSystemOut(getPrefixType(prevTypeCode) + integerSum);
                integerSum = 0;
                break;
            }
            default:
                break;
        }
    }

    private static void sendToSystemOut(Object message) {
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

    private static String getPrefixType(TypeCode typeCode) {
        switch (typeCode) {
            case STRING: {
                return typeString;
            }
            case OBJECT: {
                return typeReference;
            }
            case BYTE:
            case CHAR:
            case BOOLEAN:
            case INTEGER: {
                return typePrimitive;
            }
            default:
                return null;
        }
    }

    private static long checkOverflow(long result, Integer max, Integer min) {
        if (result > max) {
            return result - max;
        }
        if (result < min) {
            return result + min;
        }
        return result;
    }

    private static int countSum(int externalSum, int income, int max, int min) {
        long sum = (long) externalSum + (long) income;
        long result = checkOverflow(sum, max, min);

        if (result > sum) {
            sendToSystemOut(Integer.toString(min));
        } else if (result < sum) {
            sendToSystemOut(Integer.toString(max));
        }
        return (int) result;
    }
}

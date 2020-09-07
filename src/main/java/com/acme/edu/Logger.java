package com.acme.edu;


import com.acme.edu.types.MessageType;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    public static final String ARRAY_PREFIX = "primitives array: ";
    public static final String MATRIX_PREFIX = "primitives matrix: {";
    public static final String MATRIX_POSTFIX = "}";


    private static int currentIntMessage = 0;
    private static int maxIntValueAmount = 0;
    private static byte currentByteMessage = 0;
    private static byte maxByteValueAmount = 0;
    private static String currentCharMessage = "";
    private static String currentStringMessage = "";
    private static String lastStringMessage = "";
    private static int sameStringAmount = 0;
    private static MessageType lastUpdatedType = MessageType.NONE;

    public static void postProcessing() {
        printLastUpdatedType();
    }

    public static void log(int message) {
        if (lastUpdatedType != MessageType.INT) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.INT;
        }
        addMessage(message);
    }

    private static void addMessage(int message) {
        long result = (long) message + (long) currentIntMessage;
        if (result > Integer.MAX_VALUE) {
            currentIntMessage = (int) (result - Integer.MAX_VALUE);
            maxIntValueAmount++;
        } else {
            currentIntMessage = (int) result;
        }
    }

    public static void log(byte message) {
        if (lastUpdatedType != MessageType.BYTE) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.BYTE;
        }
        addMessage(message);
    }

    public static void log(char message) {
        if (lastUpdatedType != MessageType.CHAR) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.CHAR;
        }
        addMessage(message);
    }

    public static void log(String message) {
        if (lastUpdatedType != MessageType.STRING) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.STRING;
        }
        addMessage(message);
    }

    public static void log(boolean message) {
        if (lastUpdatedType != MessageType.BOOLEAN) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.BOOLEAN;
        }
        print(createMessage(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        if (lastUpdatedType != MessageType.OBJECT) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.OBJECT;
        }
        print(createMessage(REFERENCE_PREFIX, message));
    }

    public static void log(int[] intArray) {
        String arrayString = createArrayMessage(intArray);
        print(createMessage(ARRAY_PREFIX, arrayString));
    }

    public static void log(int[][] matrix) {
        print(MATRIX_PREFIX);
        for (int[] line : matrix) {
            String lineArray =  createArrayMessage(line);
            print(lineArray);
        }
        print(MATRIX_POSTFIX);
    }

    private static String createArrayMessage(int[] intArray) {
        String arrayString = "{";
        for (int i = 0; i < intArray.length-1; i++) {
            arrayString += intArray[i] + ", ";
        }
        arrayString += intArray[intArray.length-1] +"}";
        return arrayString;
    }

    private static void addMessage(byte message) {
        int result = (int) message + (int) currentByteMessage;
        if (result > Byte.MAX_VALUE) {
            currentByteMessage = (byte) (result - Byte.MAX_VALUE);
            maxByteValueAmount++;
        } else {
            currentByteMessage = (byte) result;
        }
    }

    private static void addMessage(char message) {
        currentCharMessage += message;
    }

    private static void addMessage(String message) {
        if (sameStringAmount == 0) {
            lastStringMessage = message;//a
            sameStringAmount = 1;
        } else {
            if (!message.equals(lastStringMessage)) { //b  //b
                //a
                //a
                //b
                currentStringMessage = lastStringMessage; //a
                if (sameStringAmount != 1) {
                    currentStringMessage += "(x"+ sameStringAmount + ")"; //x2
                    postProcessing(); //abc
                }

                lastStringMessage = message;
                sameStringAmount = 1;
            } else {
                if (!currentStringMessage.equals("")) postProcessing();
                sameStringAmount++;
                //1
                //2
            }
        }
    }

    private static void printLastUpdatedType() {
        switch (lastUpdatedType) {
            case INT:
                printLastUpdatedIntMessage();
                break;
            case BYTE:
                printLastUpdatedByteMessage();
                break;
            case CHAR:
                printLastUpdatedCharMessage();
                break;
            case STRING:
                if (currentStringMessage.equals("")) {
                    currentStringMessage = lastStringMessage; //a
                    if (sameStringAmount != 1) {
                        currentStringMessage += " (x"+ sameStringAmount + ")";
                        //postProcessing();
                    }
                    lastStringMessage = "";
                    sameStringAmount = 0;
                }
                printLastUpdatedStringMessage();
                break;
            default:
                break;
        }
    }

    private static void printLastUpdatedStringMessage() {
        print(createMessage(STRING_PREFIX, currentStringMessage));
        currentStringMessage = "";
        lastUpdatedType = MessageType.STRING;
    }

    private static void printLastUpdatedCharMessage() {
        print(createMessage(CHAR_PREFIX, currentCharMessage));
        currentCharMessage = "";
        lastUpdatedType = MessageType.NONE;
    }

    private static void printLastUpdatedByteMessage() {
        print(createMessage(PRIMITIVE_PREFIX, currentByteMessage));
        for (int i = 0; i < maxByteValueAmount; i++) {
            print(createMessage(PRIMITIVE_PREFIX, Byte.MAX_VALUE));
        }
        currentByteMessage = 0;
        maxByteValueAmount = 0;
        lastUpdatedType = MessageType.NONE;
    }

    private static void printLastUpdatedIntMessage() {
        print(createMessage(PRIMITIVE_PREFIX, currentIntMessage));
        for (int i = 0; i < maxIntValueAmount; i++) {
            print(createMessage(PRIMITIVE_PREFIX, Integer.MAX_VALUE));
        }
        currentIntMessage = 0;
        maxIntValueAmount = 0;
        lastUpdatedType = MessageType.NONE;
    }



    private static void print(String message) {
        System.out.println(message);
    }

    private static String createMessage(String referencePrefix, Object message) {
        return referencePrefix + message;
    }
}

package com.acme.edu;

import com.acme.edu.data.MessagePrefix;
import com.acme.edu.data.MessageType;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;

public class LoggerController {



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

    public void log(IntMessage message) {
        printIfTypeChanged(message);
        message.addMessage();
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
        print(createMessage(MessagePrefix.PRIMITIVE_PREFIX.getPrefixString(), message));


    }

    public static void log(Object message) {
        if (lastUpdatedType != MessageType.OBJECT) {
            printLastUpdatedType();
            lastUpdatedType = MessageType.OBJECT;
        }
        print(createMessage(MessagePrefix.REFERENCE_PREFIX.getPrefixString(), message));
    }

    public static void log(int[] intArray) {
        String arrayString = createArrayMessage(intArray);
        print(createMessage(MessagePrefix.ARRAY_PREFIX.getPrefixString(), arrayString));
    }

    public static void log(int[][] matrix) {
        print(MessagePrefix.MATRIX_PREFIX.getPrefixString());
        for (int[] line : matrix) {
            String lineArray =  createArrayMessage(line);
            print(lineArray);
        }
        print(MessagePrefix.MATRIX_POSTFIX.getPrefixString());
    }

    private void printIfTypeChanged(LoggerMessage message) {
        if (lastUpdatedType != message.getMessageType()) {
            printLastUpdatedType();
            lastUpdatedType = message.getMessageType();
        }
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

    public static void printLastUpdatedType() {
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
        print(createMessage(MessagePrefix.STRING_PREFIX.getPrefixString(), currentStringMessage));
        currentStringMessage = "";
        lastUpdatedType = MessageType.STRING;
    }

    private static void printLastUpdatedCharMessage() {
        print(createMessage(MessagePrefix.CHAR_PREFIX.getPrefixString(), currentCharMessage));
        currentCharMessage = "";
        lastUpdatedType = MessageType.NONE;
    }

    private static void printLastUpdatedByteMessage() {
        print(createMessage(MessagePrefix.PRIMITIVE_PREFIX.getPrefixString(), currentByteMessage));
        for (int i = 0; i < maxByteValueAmount; i++) {
            print(createMessage(MessagePrefix.PRIMITIVE_PREFIX.getPrefixString(), Byte.MAX_VALUE));
        }
        currentByteMessage = 0;
        maxByteValueAmount = 0;
        lastUpdatedType = MessageType.NONE;
    }

    private static void printLastUpdatedIntMessage() {
        print(createMessage(MessagePrefix.PRIMITIVE_PREFIX.getPrefixString(), currentIntMessage));
        for (int i = 0; i < maxIntValueAmount; i++) {
            print(createMessage(MessagePrefix.PRIMITIVE_PREFIX.getPrefixString(), Integer.MAX_VALUE));
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

package com.acme.edu;

import com.acme.edu.message.BoolMessage;
import com.acme.edu.message.Message;

public class LoggerController {

    private static String primitiveType = "primitive: ";

    private static String charType = "char: ";

    private static String stringType = "string: ";

    private static String referenceType = "reference: ";

    private static  String arrayType = "primitives array: ";

    private  static String matrixType = "primitives matrix: ";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printBuffer() {
        switch (last) {
            case INTEGER:
                printMessage(primitiveType + savedInt);
                break;
            case BYTE:
                printMessage(primitiveType + savedByte);
                break;
            case STRING:
                printMessage(stringType + savedString);
                if(stringCounter != 1){
                    System.out.print(" (x" + stringCounter + ")");
                }
                break;
        }
        System.out.println();
    }

    private static void resetBuffer() {
        savedString = "";
        savedInt = 0;
        savedByte = 0;
        stringCounter = 0;
        last = null;
    }

    private static  String getStringFromArray(int [] arr) {
        StringBuilder strForPrint = new StringBuilder("{");
        for (int i = 0; i < arr.length; i++) {
            strForPrint.append(arr[i]);
            if (i < arr.length -1) { strForPrint.append(", ");}
        }
        strForPrint.append("}");
        return strForPrint.toString();
    }
    static int savedInt = 0;
    static String savedString = "";
    static byte savedByte = 0;
    static types last = null;
    static int stringCounter = 0;

    enum types {
        INTEGER ,
        BYTE ,
        STRING
    }
    public void log(Message message){

    }

    public static void log(int message) {
        if (last != LoggerController.types.INTEGER && last != null) {
            printBuffer();
            resetBuffer();
        }
        long safe = savedInt;
        safe += message;
        if(safe > Integer.MAX_VALUE){
            printBuffer();
            resetBuffer();
            savedInt = message;
        }
        else {
            savedInt += message;
        }
        last = LoggerController.types.INTEGER;
    }

    public static void log(byte message) {
        if (last != LoggerController.types.BYTE && last != null) {
            printBuffer();
            resetBuffer();
        }
        long safe = savedByte;
        safe += message;
        if(safe > Byte.MAX_VALUE){
            printBuffer();
            resetBuffer();
            savedByte = message;
        }
        else {
            savedByte += message;
        }
        last = LoggerController.types.BYTE;
    }

    public static void log(int[] message) {
        String strForPrint = getStringFromArray(message);
        printMessage(arrayType + strForPrint);
    }

    public static void log(int[][] message) {
        System.out.println(matrixType + "{");
        for (int[] arr : message) {
            String strForPrint = getStringFromArray(arr);
            printMessage(arrayType + strForPrint);
        }
        System.out.println("}");
    }

    public static void log(char message) {
        printMessage(charType + message);
    }

    public static void log(String message) {
        if ((last != LoggerController.types.STRING && last != null) || (savedString != message && last != null)) {
            printBuffer();
            resetBuffer();
        }
        savedString = message;
        stringCounter++;
        last = LoggerController.types.STRING;
    }

    public static void log(BoolMessage message) {
        printMessage(message.toString());
    }

    public static void log(Object message) {
        printMessage(referenceType + message);
    }

    public static void flush() {
        printBuffer();
        resetBuffer();
    }
}

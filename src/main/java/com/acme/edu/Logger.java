package com.acme.edu;

import com.acme.edu.message.BoolMessage;
import com.acme.edu.message.Message;

public class Logger {
     static LoggerController loggerController = new LoggerController();


    private static void printMessage(Message message) {
        System.out.println(message);
    }

    private static void printBuffer() {
        /*
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
         */
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
            if (i< arr.length -1) { strForPrint.append(", ");}
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

    public static void main(String[] args) {

    }

    public static void flush() {
        printBuffer();
        resetBuffer();
    }

    public static void log(int message) {
        loggerController.log(message);
    }

    public static void log(byte message) {
        loggerController.log(message);
    }

    public static void log(int[] message) {
        loggerController.log(message);
    }

    public static void log(int[][] message) {
        loggerController.log(message);
    }

    public static void log(char message) {
        loggerController.log(message);
    }

    public static void log(String message) {
        loggerController.log(message);
    }

    public static void log(boolean message) {
        loggerController.log( new BoolMessage(message) );
    }

    public static void log(Object message) {
        loggerController.log(message);
    }
}

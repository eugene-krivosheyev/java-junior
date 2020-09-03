package com.acme.edu;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

public class Logger {

    private static String primitiveType = "primitive: ";

    private static String charType = "char: ";

    private static String stringType = "string: ";

    private static String referenceType = "reference: ";

    private static void printMessage(String message) {
        System.out.println(message);
    }

    static int savedInt = 0;
    static String savedString = "";
    static byte savedByte = 0;
    static types last = null;

    enum types {
        INTEGER ,
        BYTE ,
        STRING
    }

    public static void log(int message) {
        if(last == types.INTEGER){
            savedInt += message;
        }
        else{
            if(last == types.BYTE){
                last = types.BYTE;

            }
            else{

            }
        }
    }

    public static void log(byte message) {
        printMessage(primitiveType + message);
    }

    public static void log(char message) {
        printMessage(charType + message);
    }

    public static void log(String message) {
        printMessage(stringType + message);
    }

    public static void log(boolean message) {
        printMessage(primitiveType + message);
    }

    public static void log(Object message) {
        printMessage(referenceType + message);
    }
}

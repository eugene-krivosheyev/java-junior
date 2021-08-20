package com.db.edu;

import java.io.PrintStream;

public class Logger {

    private static final PrintStream OUT = System.out;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    private static int sum = 0;
    private static boolean hasNumberToPublish = false;
    private static boolean hasPreviousString = false;
    private static String savedString = "";
    private static int equalStringAmount=0;

    public static void flush() {
        flushNumber();
        flushString();
    }

    private static void flushNumber(){
        if (hasNumberToPublish){
            OUT.println(PRIMITIVE_PREFIX+sum);
            hasNumberToPublish = false;
        }
        sum=0;
    }
    private static void flushString(){
        if (hasPreviousString){
            if (equalStringAmount==1){
                OUT.println(STRING_PREFIX+savedString);
            }
            else{
                OUT.println(STRING_PREFIX+savedString+" (x"+equalStringAmount+")");
            }
            hasPreviousString=false;
        }
        equalStringAmount = 0;
    }

    private static void addValueToSum(int value){
        hasNumberToPublish = true;
        long sumResultValue = (long)sum+(long)value;
        if (sumResultValue>Integer.MAX_VALUE)
        {
            flush();
            sum=value;
            hasNumberToPublish = true;
        }
        else
        {
            sum+=value;
        }
    }

    public static void log(int message) {
        flushString();
        addValueToSum(message);
    }

    public static void log(byte message) {
        OUT.println(PRIMITIVE_PREFIX+message);
    }

    public static void log(char message) {
        OUT.println(CHAR_PREFIX + message);
    }

    public static void log(boolean message) {
        OUT.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(String message) {
        flushNumber();
        if (hasPreviousString){
            if (savedString.equals(message)) {
                equalStringAmount++;
            }
            else {
                if (equalStringAmount==1){
                    OUT.println(STRING_PREFIX+savedString);
                }
                else{
                    OUT.println(STRING_PREFIX+savedString+" (x"+equalStringAmount+")");
                }
                savedString = message;
                equalStringAmount=1;
            }
        }
        else{
            savedString = message;
            equalStringAmount=1;
            hasPreviousString=true;
        }

    }

    public static void log(Object message) {
        OUT.println(REFERENCE_PREFIX + message);
    }
}

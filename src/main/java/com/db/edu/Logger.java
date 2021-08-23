package com.db.edu;

import java.io.PrintStream;
import java.util.Arrays;

public class Logger {

    private static final PrintStream OUT = System.out;
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String ARRAY_PREFIX = "primitives array: ";

    private static int sum = 0;
    private static boolean hasNumberToPublish = false;
    private static boolean hasPreviousString = false;
    private static String savedString = "";
    private static int equalStringAmount=0;

    private Logger(){
    }

    public static void flush() {
        flushNumber();
        flushString();
    }

    public static void log(int[] messages){
        printToStream(ARRAY_PREFIX + Arrays.toString(messages)
                                            .replace("[","{")
                                            .replace("]","}"));
    }

    public static void log(String... messages){
        for (String message: messages){
            printToStream(STRING_PREFIX + message);
        }
    }

    public static void log(int firstMessage,int... messages){
        int sumOfElements = firstMessage+Arrays.stream(messages).sum();
        printToStream(Integer.toString(sumOfElements));
    }

    public static void log(int message) {
        flushString();
        addValueToSum(message);
    }

    public static void log(byte message) {
        printToStream(PRIMITIVE_PREFIX+message);
    }

    public static void log(char message) {
        printToStream(CHAR_PREFIX + message);
    }

    public static void log(boolean message) {
        printToStream(PRIMITIVE_PREFIX + message);
    }

    public static void log(String message) {
        flushNumber();
        if (hasPreviousString){
            if (savedString.equals(message)) {
                equalStringAmount++;
            }
            else {
                if (equalStringAmount==1){
                    printToStream(STRING_PREFIX+savedString);
                }
                else{
                    printToStream(STRING_PREFIX+savedString+" (x"+equalStringAmount+")");
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
        printToStream(REFERENCE_PREFIX + message);
    }

    private static void printToStream(String message){
        OUT.println(message);
    }

    private static void flushNumber(){
        if (hasNumberToPublish){
            printToStream(PRIMITIVE_PREFIX+sum);
            hasNumberToPublish = false;
        }
        sum=0;
    }
    private static void flushString(){
        if (hasPreviousString){
            if (equalStringAmount==1){
                printToStream(STRING_PREFIX+savedString);
            }
            else{
                printToStream(STRING_PREFIX+savedString+" (x"+equalStringAmount+")");
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
}

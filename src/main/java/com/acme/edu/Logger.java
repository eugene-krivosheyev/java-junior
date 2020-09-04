package com.acme.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a simple logger for some standard Java types.
 * @version 1.0.2
 */
public class Logger {

    static String logMessage;
    static List<Object> listOfLog = new ArrayList<>();

    static final String CHAR_PREFIX = "char: ";
    static final String STRING_PREFIX = "string: ";
    static final String REFERENCE_PREFIX = "reference: ";
    static final String PRIMITIVE_PREFIX = "primitive: ";

    private static void writeMessage() {
        System.out.println(logMessage);
    }

    /**
     * @param  message  an integer value to be logged
     */
    public static void log(int message) {
        listOfLog.add(message);
    }

    public static void log(byte message) {
        listOfLog.add(message);
    }

    public static void log(boolean message) {

        logMessage = PRIMITIVE_PREFIX + message;
        writeMessage();
    }

    public static void log(char message) {
        logMessage = CHAR_PREFIX + message;
        writeMessage();
    }

    public static void log(String message) {
        listOfLog.add(message);
    }

    public static void log(Object message) {
        logMessage = REFERENCE_PREFIX + message;
        writeMessage();
    }

    public static void flush(){
        if ( listOfLog.get(0) instanceof Integer ){
            sumInt();
        } else if ( listOfLog.get(0) instanceof Byte ){
            sumByte();
        } else if( listOfLog.get(0) instanceof String){
            sumString();
        }

    }

    public static void sumInt(){
        int sum = 0;
        for (int i = 0; i < listOfLog.size(); i++){
            if( Integer.MAX_VALUE - sum >= (int)listOfLog.get(i)){
                sum += (int)listOfLog.get(i);
            } else{
                sum = (int)listOfLog.get(i) - (Integer.MAX_VALUE - sum);
                logMessage = PRIMITIVE_PREFIX + Integer.MAX_VALUE;
                writeMessage();
            }
        }
        logMessage = PRIMITIVE_PREFIX + sum;
        writeMessage();
        listOfLog.clear();
    }

    public static void sumByte(){
        byte sum = 0;
        for (int i = 0; i < listOfLog.size(); i++){
            if( Byte.MAX_VALUE - sum >= (byte)listOfLog.get(i)){
                sum += (byte)listOfLog.get(i);
            } else{
                sum = (byte) ((byte)listOfLog.get(i) - (Byte.MAX_VALUE - sum));
                logMessage = PRIMITIVE_PREFIX + Byte.MAX_VALUE;
                writeMessage();
            }
        }
        logMessage = PRIMITIVE_PREFIX + sum;
        writeMessage();
        listOfLog.clear();
    }

    public static void sumString(){
        logMessage = STRING_PREFIX + listOfLog.get(0);
        writeMessage();
        listOfLog.clear();
    }

}
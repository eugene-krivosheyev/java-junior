package com.acme.edu;

import com.acme.edu.command.*;

import static java.lang.String.valueOf;

public class Logger {
    private static LoggerController loggerController = new LoggerController();

    public static void flush() {
        loggerController.flush();
    }

    public static void close() {
        flush();
        loggerController = new LoggerController();
    }

    public static void log(int message) {
        loggerController.log(new IntCommand(message));
    }

    public static void log(int... message) {
        loggerController.log(new IntMasCommand(message));
    }

    public static void log(int[][] message) {
        loggerController.log(new IntMas2Command(message));
    }

    public static void log(int[][][][] message) {
        loggerController.log(new IntMas4Command(message));
    }

    public static void log(byte message) {
        loggerController.log(new ByteCommand(message));
    }

    public static void log(char message) {
        loggerController.log(new CharCommand(message));
    }

    public static void log(String message) {
        loggerController.log(new StringCommand(message));
    }

    public static void log(String... message) {
        for(String s:message){
            loggerController.log(new StringCommand(s));
        }

    }

    public static void log(boolean message) {
        loggerController.log(new BooleanCommand(message));
    }

    public static void log(Object message) {
       loggerController.log(new ObjectCommand(message));
    }


/*
    private static void typeLog(String type, String message) {
        saveSpecificMessage(type + ": " + message);
    }

    private static void primitiveTypeLog(String message) {
        saveSpecificMessage("primitive: " + message);
    }

    private static void saveSpecificMessage(String message) {
        System.out.println(message);
    }
//TODO : reuse
    public static void log(int... message){
        typeLog("primitives array", messageDecorate(message));
    }

    public static void log(int[][] message){
        typeLog("primitives matrix", messageDecorate(message));
    }

    public static void log(int[][][] message){
        typeLog("primitives multimatrix", messageDecorate(message));
    }

    public static void log(int[][][][] message){
        typeLog("primitives multimatrix", messageDecorate(message));
    }

    public static void log(String... message) {
        for(String currentString : message) {
            log(currentString);
        }
    }

    private static String messageDecorate(int[] message) {
        String answer = "{";
        for(int currentValue:message){
            answer+=currentValue + ", ";
        }
        answer=answer.substring(0,answer.length()-2);
        return answer + "}";
   }

    private static String messageDecorate(int[][] message) {
        String answer = "{"+separator;
        for(int[] currentValue:message){
            answer+=messageDecorate(currentValue)+separator;
        }
        return answer + "}";
    }

    private static String messageDecorate(int[][][] message) {
        String answer = "{"+separator;
        for(int[][] currentValue:message){
            answer+=messageDecorate(currentValue)+separator;
        }
        return answer + "}";
    }

    private static String messageDecorate(int[][][][] message){
        String answer = "{"+separator;
        for(int[][][] currentValue:message){
            answer+=messageDecorate(currentValue)+separator;
        }
        return answer + "}";
    }



    private static boolean checkOverflow(int message) {
        if (intBuff > 0 && (Integer.MAX_VALUE - intBuff < message)) return true;
        if (intBuff <= 0 && (Integer.MIN_VALUE - intBuff > message)) return true;
        return false;
    }

    private static boolean checkOverflow(byte message) {
        if (byteBuff > 0 && (Byte.MAX_VALUE - byteBuff < message)) return true;
        if (byteBuff <= 0 && (Byte.MIN_VALUE - byteBuff > message)) return true;
        return false;
    }*/
}

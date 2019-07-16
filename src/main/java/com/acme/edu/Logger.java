package com.acme.edu;

import static java.lang.String.valueOf;

public class Logger {
    private static int intBuff = 0;
    private static byte byteBuff = 0;

    private static String strBuff = "";
    private static int strCount = 0;

    private static String currentType = "none";

    private static String separator = System.lineSeparator();

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

    public static void log(int message) {
        if (!"int".equals(currentType) || checkOverflow(message)) {
            flush();
            intBuff = message;
            currentType = "int";
            return;
        }
        intBuff += message;
    }

    public static void log(byte message) {
        if (!"byte".equals(currentType) || checkOverflow(message)) {
            flush();
            byteBuff = message;
            currentType = "byte";
            return;
        }
        byteBuff += message;
    }

    public static void log(boolean message) {
        primitiveTypeLog(valueOf(message));
    }

    public static void log(char message) {
        typeLog("char", valueOf(message));
    }

    public static void log(String message) {
        if (!"string".equals(currentType) || !message.equals(strBuff)) {
            flush();
            strBuff = message;
            strCount = 1;
            currentType = "string";
            return;
        }
        strCount++;
    }

    public static void log(String... message) {
        for(String currentString : message) {
            log(currentString);
        }
    }

    public static void log(Object message) {
        if (message != null) {
            typeLog("reference", message.toString());
        } else {
            typeLog("reference", "null");
        }
    }

    public static void flush() {
        switch (currentType) {
            case "int": {
                saveSpecificMessage(messageDecorate(intBuff));
                intBuff = 0;
                break;
            }
            case "byte": {
                saveSpecificMessage(messageDecorate(byteBuff));
                byteBuff = 0;
                break;
            }
            case "string": {
                saveSpecificMessage(messageDecorate(strBuff));
                strBuff = "";
                strCount = 0;
                break;
            }
        }
    }

    public static void close() {
        flush();
        intBuff = 0;
        byteBuff = 0;
        strBuff = "";
        strCount = 0;
        currentType = "none";
    }

    private static String messageDecorate(int message) {
        return valueOf(message);
    }

    private static String messageDecorate(byte message) {
        return valueOf(message);
    }

    private static String messageDecorate(String message) {
        if (strCount == 1) {
            return message;
        } else {
            return message + " (x" + strCount + ")";
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
    }
}

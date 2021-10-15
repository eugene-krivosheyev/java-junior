package com.acme.edu;

import java.util.Objects;

public class Logger {
    private static boolean isSumming = false;
    private static String collectingType = "";

    private static Integer bufferInteger = 0;
    private static String  bufferString  = "";
    private static Integer stringCounter = 0;

    public static void setSumming(boolean isSum){isSumming = isSum;}

    public static void log(int message) {
        prepare(int.class.getTypeName(), String.valueOf(message));
    }

    public static void log(char message) {
        prepare(char.class.getTypeName(), String.valueOf(message));
    }

    public static void log(byte message) {
        prepare(byte.class.getTypeName(), String.valueOf(message));
    }

    public static void log(String message) {
        prepare(String.class.getTypeName(), String.valueOf(message));
    }

    public static void log(Boolean message) {
        prepare(Boolean.class.getTypeName(), String.valueOf(message));
    }

    public static void log(Object message) {
        prepare(Object.class.getTypeName(), String.valueOf(message));
    }

    public static void endLog(){
        if(String.class.getTypeName() == collectingType){
            if(stringCounter != 0){
                print(stringMsg(bufferString,stringCounter));
            }
        } else if (int.class.getTypeName() == collectingType){
            print(bufferInteger.toString());
        }
    }

    private static String prefix(String type) {
        if (String.class.getTypeName() == type) {
            return "string: ";
        } else if (char.class.getTypeName() == type) {
            return "char: ";
        } else if (Object.class.getTypeName() == type) {
            return "reference: ";
        } else {
            return "primitive: ";
        }
    }

    private static String formatMsg(String type, String message) {
        return prefix(type) + message;
    }

    private static void print(String message){System.out.println(message);}

    private static String stringMsg(String message, Integer count){
        if (count != 1) {return String.format("%s (x%d)", message,count);}
        return message;
    }

    private static void prepare(String classType, String message) {
        if (!isSumming) {
            print(formatMsg(classType, message));
        } else {
            workWithSumming(classType, message);
        }
    }

    private static void workWithSumming(String classType, String message) {
        if (Objects.equals(classType,collectingType)){
            workWithSameType(classType, message);
        } else {
            workWithAnotherType(classType, message);
        }
    }

    private static void workWithAnotherType(String classType, String message) {
        endWorkWithPreviosType();
        startWorkWithNewType(classType, message);
    }

    private static void startWorkWithNewType(String classType, String message) {
        collectingType = classType;
        if(String.class.getTypeName() == classType){
            bufferString = message;
            stringCounter = 1;
        } else if (int.class.getTypeName() == classType){
            bufferInteger = Integer.valueOf(message);
        } else {
            print(message);
        }
    }

    private static void endWorkWithPreviosType() {
        if(String.class.getTypeName() == collectingType){
            if(stringCounter != 0){
                print(stringMsg(bufferString,stringCounter));
                stringCounter = 0;
            }
        } else if (int.class.getTypeName() == collectingType){
            print(bufferInteger.toString());
            bufferInteger = 0;
        } else {
            bufferString = "";
            stringCounter = 0;
            bufferInteger = 0;
        }
    }

    private static void workWithSameType(String classType, String message) {
        if(String.class.getTypeName() == classType){
            workWithString(message);
        } else if (int.class.getTypeName() == classType){
            workWithInteger(message);
        } else {
            print(message);
        }
    }

    private static void workWithInteger(String message) {
        if ((Integer.MAX_VALUE - bufferInteger < Integer.valueOf(message).intValue())
        ||  (Integer.MIN_VALUE - bufferInteger > Integer.valueOf(message).intValue())){
            print(bufferInteger.toString());
            bufferInteger = 0;
        }
        bufferInteger = (bufferInteger + Integer.valueOf(message).intValue());
    }

    private static void workWithString(String message) {
        if(Objects.equals(message,bufferString)){
            stringCounter++;
        } else {
            print(stringMsg(bufferString,stringCounter));
            stringCounter = 1;
            bufferString = message;
        }
    }
}

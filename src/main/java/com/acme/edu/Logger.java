package com.acme.edu;

public class Logger {
    private final static String PREFIX_CHAR = "char ";
    private final static String PREFIX_STRING = "";
    private final static String PREFIX_REFERENCE = "reference ";
    private final static String PREFIX_PRIMITIVE = "";
    private static String lastStringValue = "";
    private static int lastIntValue;
    private static String lastType = "";
    private static int counter = 1;

    private static boolean isEqualLastType(String type){
        return type.equals(lastType);
    }
    public static void log(int message) {
        if(Integer.MAX_VALUE == message){
            if(isEqualLastType("int")){
                writeMessage(PREFIX_PRIMITIVE + lastIntValue);
            }
            System.out.println(message);
            lastIntValue = 0;
            lastType = "";
        }
        else if(isEqualLastType("int")){
            lastIntValue += message;
        }
        else{
//            if(counter != 1){
//                lastStringValue += " (x" + counter + ")";
//            }
//            if(!lastStringValue.equals("")){
//                writeMessage(lastStringValue);
//            }
            lastIntValue = message;
            lastType = "int";
        }
    }

    public static void log(char message) {
        writeMessage(PREFIX_CHAR + message);
    }

    public static void log(boolean message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(String message) {
        if(!isEqualLastType("str")){
//            lastStringValue += message;
//        }
//        else {
            if(isEqualLastType("int")){
                writeMessage(PREFIX_PRIMITIVE + lastIntValue);
            }
        }
        writeMessage(PREFIX_STRING + message);
    }

    public static void log(byte message) {
        writeMessage(PREFIX_PRIMITIVE + message);
    }

    public static void log(Object message) {
        writeMessage(PREFIX_REFERENCE + message);
    }


    static void writeMessage(String outputString){
        System.out.println(outputString);
    }

    private static boolean isFirstValue(String  message) {
        return message.equals("");
    }

}
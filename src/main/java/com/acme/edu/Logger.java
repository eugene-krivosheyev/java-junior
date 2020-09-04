package com.acme.edu;

public class Logger {
    private final static String PREFIX_CHAR = "char ";
    private final static String PREFIX_STRING = "";
    private final static String PREFIX_REFERENCE = "reference ";
    private final static String PREFIX_PRIMITIVE = "";
    private static String lastStringValue = "";
    private static String countedStringValue = "";
    private static int lastIntValue = 0;
    private static String lastType = "";
    private static int counter = 1;
    private static byte lastByteValue = 0;

    private static boolean isEqualLastType(String type){
        return type.equals(lastType);
    }
    public static void log(int message) {
        if(Integer.MAX_VALUE == message){
            if(isEqualLastType("int")){
                writeMessage(lastType);
            }
            System.out.println(message);
            lastIntValue = 0;
            lastType = "";
        }
        else if(isEqualLastType("int")){
            lastIntValue += message;
        }
        else{
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
        if(isEqualLastType("str")){
            if(countedStringValue.equals(message)){
                counter++;
                if(counter == 2 && !countedStringValue.equals(lastStringValue)) {
                        writeMessage(lastType);
                        lastStringValue = countedStringValue;
                }
            }
            else{
                if(counter == 1){
                    if(!countedStringValue.equals(lastStringValue)){
                        lastStringValue += countedStringValue;
                    }
                }
                else{
                    lastStringValue += " (x" + counter + ")";
                    writeMessage(lastType);
                    lastStringValue = message;
                    counter = 1;
                }
                countedStringValue = message;
            }
        }
        else {
            counter = 1;
            writeMessage(lastType);
            countedStringValue = message;
            lastStringValue = message;
        }
    }

    public static void log(byte message) {
        if(Byte.MAX_VALUE == message){
            if(isEqualLastType("byte")){
                writeMessage(PREFIX_PRIMITIVE + lastByteValue);
            }
            System.out.println(message);
            lastByteValue = 0;
            lastType = "";
        }
        else if(isEqualLastType("byte")){
            lastByteValue += message;
        }
        else{
            writeMessage(lastType);
            lastByteValue = message;
            lastType = "byte";
        }
    }

    public static void log(Object message) {
        writeMessage(PREFIX_REFERENCE + message);
    }

    static void writeMessage(String lastType){
        String outputString = "";
        switch (lastType){
            case "int": outputString += lastIntValue; break;
            case "byte": outputString += lastByteValue; break;
            case "str": outputString = lastStringValue; break;
        }
        System.out.println(outputString);
    }

}
package com.acme.edu;

public class Logger {
    private static final String STR_PREFIX = "string: ";
    private static final String PRIM_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String OBJ_PREFIX = "reference: ";

    private static final String INT_TYPE = "int";
    private static final String STRING_TYPE = "string";
    private static final String BYTE_TYPE = "byte";
    private static String containerType= "";
    private static String stringContainer = "";
    private static int stringsCount = 0;
    private static int intContainer = 0;


    public static void log(int message) {
        typeCheck(INT_TYPE);
        primOps(message, Integer.MAX_VALUE);
    }

    public static void log(byte message) {
        typeCheck(BYTE_TYPE);
        primOps(message,Byte.MAX_VALUE);
    }

    public static void log(char message) {
        getPrintln(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        typeCheck(STRING_TYPE);
        if (stringContainer.isEmpty()) {
            stringContainer = message;
        }else if (!message.equals(stringContainer)){
            flush();
            stringContainer=message;
        }
        stringsCount++;
    }

    public static void log(boolean message) {
        getPrintln(PRIM_PREFIX + message);
    }

    public static void log(Object message) {
        getPrintln(OBJ_PREFIX + message);

    }

    private static void getPrintln(Object message) {
        System.out.println(message);
    }

    public static void flush(){
        switch (containerType){
            case STRING_TYPE:
                if (stringsCount > 1)
                    getPrintln (STR_PREFIX + stringContainer + " (x" + stringsCount + ")");
                else getPrintln (STR_PREFIX + stringContainer);
                stringContainer="";
                stringsCount=0;
                break;
            case INT_TYPE:
            case BYTE_TYPE:
                getPrintln(PRIM_PREFIX + intContainer);
                intContainer = 0;
                break;
        }
    }

    private static void typeCheck(String currentType){
        if (containerType.isEmpty()){
            containerType=currentType;
        }else if (!containerType.equals(currentType)){
            flush();
            containerType=currentType;
        }
    }

    public static void primOps(int number, int full){
            int prefull = full - intContainer;
            if (number >= prefull) {
                intContainer = full;
                flush();
                intContainer = number - prefull;
            } else {
                intContainer += number;
            }
        }

}

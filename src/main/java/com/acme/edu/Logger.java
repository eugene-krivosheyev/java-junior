package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";
    public static final OutputMethod OUTPUT_METHOD = OutputMethod.TERMINAL;
    public static boolean intAccIsNotEmpty = false;
    private static long intAccumulator = 0;
    public static boolean byteAccIsNotEmpty = false;
    private static int byteAccumulator = 0;
    private static String currentString;
    private static String prevString;
    private static int strRepeatCounter = 1;


    public static void log(int message) { output(OUTPUT_METHOD,PRIMITIVE_PREFIX, message); }

    public static void log(byte message) { output(OUTPUT_METHOD,PRIMITIVE_PREFIX, message); }

    public static void log(char message) { output(OUTPUT_METHOD, CHAR_PREFIX, message); }

    public static void log(String message) { output(OUTPUT_METHOD,STRING_PREFIX, message); }

    public static void log(boolean message) { output(OUTPUT_METHOD,PRIMITIVE_PREFIX, message); }

    public static void log(Object message) { output(OUTPUT_METHOD,OBJECT_PREFIX, message); }

    private static void output(OutputMethod outputMethod, String prefix, Object message) {
        if (outputMethod == OutputMethod.TERMINAL) {
            switch (message.getClass().getSimpleName()) {
                case ("Integer"):
                    accumulator((int) message);
                    break;
                case ("Byte"):
                    accumulator((byte) message);
                    break;
                case ("String"):
                    stringHandler((String) message);
                    break;
                default:
                    System.out.println(prefix + message);
                    break;
            }
        }
        else if(outputMethod == OutputMethod.FILE) {
            //write to file
        }
    }

    private static void accumulator(int i) {
        intAccumulator += i;
        intAccIsNotEmpty = true;
    }

    private static void accumulator(byte b) {
        byteAccumulator += b;
        byteAccIsNotEmpty = true;
    }

    public static void flush() {
        if (intAccIsNotEmpty) {
            System.out.println(PRIMITIVE_PREFIX + intAccumulator);
            intAccumulator = 0;
            intAccIsNotEmpty = false;
        }
        if (byteAccIsNotEmpty) {
            System.out.println(PRIMITIVE_PREFIX + byteAccumulator);
            byteAccumulator = 0;
            byteAccIsNotEmpty = false;
        }
    }

//    public static void stringHandler(String message) { //str 2
//        if (currentString != message && currentString != null) { //
//            if (strRepeatCounter == 1) {
//                System.out.println(currentString);
//
//                currentString = message;
//                strRepeatCounter = 1;
//            } else {
//                if (strRepeatCounter > 1) {
//                    System.out.println(currentString + " (x" + strRepeatCounter + ")");
//                }
//                currentString = message;
//                strRepeatCounter = 1;
//            }
//
//        } else if (currentString == message) {
//            if (strRepeatCounter == 1) {
//                System.out.println(prevString);
//            } else {
//                System.out.println(prevString + " (x" + strRepeatCounter + ")");
//            }
//            strRepeatCounter += 1;
//        } else if (currentString != message && currentString == null) { //get here on 1st iteration
//            currentString = message;
//        }
//
//
//    }


    enum OutputMethod {
        TERMINAL, FILE
    }
}


/*
public static void stringHandler(String message) { //str 2
        if (currentString != message && currentString != null) { //if str 1 != str 2
            if (strRepeatCounter == 1) {
                System.out.println(currentString);

                currentString = message;
                strRepeatCounter = 1;
            } else {
                if (strRepeatCounter > 1) {
                    System.out.println(currentString + " (x" + strRepeatCounter + ")");
                }
                currentString = message;
                strRepeatCounter = 1;
            }

        } else if (currentString == message) {
//            if (strRepeatCounter == 1) {
//                System.out.println(prevString);
//            } else {
//                System.out.println(prevString + " (x" + strRepeatCounter + ")");
//            }
            strRepeatCounter += 1;
        } else if (currentString != message && currentString == null) {
            currentString = message;
        }


    }
 */
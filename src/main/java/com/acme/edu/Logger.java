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
    private static String savedString;
    private static int strRepeatitionCounter = 0;


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
//                case ("String"):
//
//                    break;
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

//    public static void stringHandler(String message) {
//
//    }


    enum OutputMethod {
        TERMINAL, FILE
    }
}

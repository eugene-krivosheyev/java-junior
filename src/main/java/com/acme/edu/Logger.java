package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";
    public static final OutputMethod OUTPUT_METHOD = OutputMethod.TERMINAL;

    public static void log(int message) { output(OUTPUT_METHOD,PRIMITIVE_PREFIX, message); }

    public static void log(byte message) { output(OUTPUT_METHOD,PRIMITIVE_PREFIX, message); }

    public static void log(char message) { output(OUTPUT_METHOD, CHAR_PREFIX, message); }

    public static void log(String message) { output(OUTPUT_METHOD,STRING_PREFIX, message); }

    public static void log(boolean message) { output(OUTPUT_METHOD,PRIMITIVE_PREFIX, message); }

    public static void log(Object message) { output(OUTPUT_METHOD,OBJECT_PREFIX, message); }

    private static void output(OutputMethod outputMethod, String prefix, Object message) {
        if (outputMethod == OutputMethod.TERMINAL) {
            System.out.println(prefix + message);
        }
        else if(outputMethod == OutputMethod.FILE) {
            //write to file
        }
    }

    enum OutputMethod {
        TERMINAL, FILE
    }
}

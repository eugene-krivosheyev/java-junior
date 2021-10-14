package com.acme.edu;

public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String OBJECT_PREFIX = "reference: ";

    public static void log(int message) {
        output('c',PRIMITIVE_PREFIX, message);
    }

    public static void log(byte message) {
        output('c',PRIMITIVE_PREFIX, message);
    }

    public static void log(char message) { output('c', CHAR_PREFIX, message); }

    public static void log(String message) { output('c',STRING_PREFIX, message); }

    public static void log(boolean message) { output('c',PRIMITIVE_PREFIX, message); }


    public static void log(Object message) { output('c',OBJECT_PREFIX, message); }

    private static void output(char output_method, String prefix, Object message){
        if (output_method == 'c'){
            System.out.println(prefix + message);
        }
        else if(output_method == 'f'){
            //write to file
        }
    }
}

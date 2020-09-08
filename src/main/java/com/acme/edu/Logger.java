package com.acme.edu;

import static java.lang.System.lineSeparator;

public class Logger {
    private static LoggerController controller = new LoggerController(new ConsoleSaver());


    /*public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: ";
    public static final String PREFIX_MATRIX = "primitives matrix: ";
    public static final String PREFIX_ARRAY = "primitives array: ";

    public static String type = "";
    public static int int_buffer = 0;
    public static byte byte_buffer = 0;
    public static String string_buffer = "";
    public static int counter = 0;*/


    public static void log(int message) {
        controller.log(new IntCommand(message));
    }
/*
    public static void log(byte message) {
        controller.log(new ByteCommand(message));
    }

     public static void log(char message) {
         controller.log(new CharCommand(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanCommand(message));
    }
*/
    public static void log(String message) {
        controller.log(new StringCommand(message));
    }
/*
    public static void log(Object message) {
        controller.log(new ObjectCommand(message));
    }

    public static void log(int[][] matrix){
        controller.log(new MatrixCommand(matrix));
    }

    public static void log(int[] array) {
        controller.log(new ArrayCommand(array));
    }
/*
*/
    public static void flush() {
        controller.flush();
    }
/*
    private static void chooseMessageWriter(){
        switch (type){
            case "int":{
                writeMessage(PREFIX_PRIMITIVE + int_buffer);
                int_buffer = 0;
                break;
            }
            case "byte":{
                writeMessage(PREFIX_PRIMITIVE + byte_buffer);
                byte_buffer = 0;
                break;
            }
            case "string":{
                if(counter>0) {
                    counter++;
                    writeMessage(PREFIX_STRING + string_buffer+" (x"+counter+")");
                }
                else {
                    writeMessage(PREFIX_STRING + string_buffer);
                }
                string_buffer = "";
                counter = 0;
                break;
            }
            case "":
                break;
        }
    }*/
}

package com.acme.edu;

public class Logger {

    public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: ";

    public static String type="";
    public static int int_buffer=0;
    public static byte byte_buffer=0;
    public static String string_buffer="";


    public static void log(int message) {
        if (type.equals("")) {
                type = "int";
                int_buffer = message;
            } else {
                    if ("int".equals(type)) {
                        int_buffer +=message;
                    } else {
                        Method();
                        type = "int";
                        int_buffer = message;
                    }
            }
    }

    public static void log(byte message) {
        if (type.equals("")) {
            type = "byte";
            byte_buffer = message;
        } else {
            if ("byte".equals(type)) {
                byte_buffer +=message;
            } else {
                Method();
                type = "byte";
                byte_buffer = message;
            }
        }
    }

     public static void log(char message) {
        Method();
        writeMessage(PREFIX_CHAR + message);
        type="";
    }

    public static void log(boolean message) {
        Method();
        writeMessage(PREFIX_PRIMITIVE + message);
        type="";
    }

    public static void log(String message) {
        if (type.equals("")) {
            type = "string";
            string_buffer = message;
        } else {
            if ("string".equals(type)) {
                string_buffer +=message;
            } else {
                Method();
                type = "string";
                string_buffer = message;
            }
        }
        if (counter == 0) {
            writeMessage(PREFIX_STRING + message);
            counter = 1;
        }
        else{
            if (type.equals("")) {
                type = "String";
                value = message;
            } else {
                if ("String".equals(type)) {
                    if (message.equals(value)) {
                        counter = 2;
                        message = message + " (x" + counter + ")";
                    } else {
                        counter = 1;
                        message += value;
                    }
                } else {
                    counter = 0;
                    log(value);
                    type = "String";
                    value = message;
                }
            }
        }
    }

    public static void log(Object message) {
        Method();
        writeMessage(PREFIX_REFERENCE + message);
        type="";
    }

    private static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void flush() {
        Method();
        type="";

    }
    public static void Method(){
        switch (type){
            case "int":{
                writeMessage(PREFIX_PRIMITIVE + int_buffer);
                int_buffer=0;
                break;
            }
            case "byte":{
                writeMessage(PREFIX_PRIMITIVE + byte_buffer);
                byte_buffer=0;
                break;
            }
            case "string":{
                writeMessage(PREFIX_STRING+ string_buffer);
                string_buffer="";
                break;
            }
        }
    }
}

package com.acme.edu;

public class Logger {

    public static final String PREFIX_PRIMITIVE = "primitive: ";
    public static final String PREFIX_CHAR = "char: ";
    public static final String PREFIX_STRING = "string: ";
    public static final String PREFIX_REFERENCE = "reference: ";
    public static final String PREFIX_MATRIX = "primitives matrix: ";
    public static final String PREFIX_ARRAY = "primitives array: ";

    public static String type = "";
    public static int int_buffer = 0;
    public static byte byte_buffer = 0;
    public static String string_buffer = "";
    public static int counter = 0;


    public static void log(int message) {
        if (type.equals("")) {
                type = "int";
                int_buffer = message;
            } else {
                    if ("int".equals(type) && (Integer.MAX_VALUE - int_buffer >= message)) {
                        int_buffer += message;
                    } else {
                        chooseMessageWriter();
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
            if ("byte".equals(type) && (Byte.MAX_VALUE - byte_buffer >= message)) {
                byte_buffer += message;
            } else {
                chooseMessageWriter();
                type = "byte";
                byte_buffer = message;
            }
        }
    }

     public static void log(char message) {
        chooseMessageWriter();
        writeMessage(PREFIX_CHAR + message);
        type = "";
    }

    public static void log(boolean message) {
        chooseMessageWriter();
        writeMessage(PREFIX_PRIMITIVE + message);
        type = "";
    }

    public static void log(String message) {
        if (type.equals("")) {
            type = "string";
            string_buffer = message;
        } else {
            if ("string".equals(type)) {
                if(string_buffer.equals(message)){
                    counter++;
                }
                else {
                    chooseMessageWriter();
                    string_buffer = message;
                }
            } else {
                chooseMessageWriter();
                type = "string";
                string_buffer = message;
            }
        }
    }

    public static void log(Object message) {
        chooseMessageWriter();
        writeMessage(PREFIX_REFERENCE + message);
        type = "";
    }

    public static void log(int[][] matrix){
        StringBuilder messageString = new StringBuilder(PREFIX_MATRIX+"{"+System.lineSeparator());
        for(int i=0; i<matrix[0].length; i++){
            messageString.append("{");
            for(int num : matrix[i]){
                messageString.append(num+", ");
            }
            messageString.delete(messageString.length()-2,messageString.length());
            messageString.append("}"+System.lineSeparator());
        }
        messageString.append("}");
        System.out.println(messageString);
    }

    public static void log(int[] array) {
        StringBuilder builder = new StringBuilder("{");
        for (int num: array) {
            builder.append(num + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("}");
        writeMessage(PREFIX_ARRAY + builder);
    }

    private static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void flush() {
        chooseMessageWriter();
        type = "";

    }

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
    }
}

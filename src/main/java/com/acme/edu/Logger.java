package com.acme.edu;


import com.acme.edu.command.IntMessage;
import com.acme.edu.command.StringMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class Logger {
    private static LoggerController controller = new LoggerController(new ConsoleLoggerSaver());


    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void flush() {
        controller.flush();
    }
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


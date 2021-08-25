package com.db.edu;

import com.db.edu.controller.Controller;
import com.db.edu.command.*;

import java.io.PrintStream;
import java.util.Arrays;

public class Logger {


    private static final Controller controller = new Controller();

    private Logger(){
    }

    public static void log(int message) {
        controller.log(new IntCommand(message));
    }

    public static void log(String message) {
        controller.log(new StringCommand(message));
    }

    public static void flush(){
        controller.flush();
    }

    /*public static void log(int[] messages){
        printToStream(ARRAY_PREFIX + Arrays.toString(messages)
                                            .replace("[","{")
                                            .replace("]","}"));
    }

    public static void log(String... messages){
        for (String message: messages){
            printToStream(STRING_PREFIX + message);
        }
    }

    public static void log(int firstMessage,int... messages){
        int sumOfElements = firstMessage+Arrays.stream(messages).sum();
        printToStream(Integer.toString(sumOfElements));
    }*/



    /*public static void log(byte message) {
        printToStream(PRIMITIVE_PREFIX+message);
    }

    public static void log(char message) {
        printToStream(CHAR_PREFIX + message);
    }

    public static void log(boolean message) {
        printToStream(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        printToStream(REFERENCE_PREFIX + message);
    }*/
}

package com.db.edu;


import com.db.edu.message.BooleanMessage;
import com.db.edu.message.ByteMessage;
import com.db.edu.message.IntMessage;
import com.db.edu.message.StringMessage;

public class Logger {
    private static final Controller controller = new Controller();

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

//    public static void log(char message) {
//        controller.log(message);
//    }
//
//    public static void log(Object message) {
//        controller.log(message);
//    }
//
//    public static void log(int ... message) {
//        controller.log(message);
//    }
//
//    public static void log(String  ... message) {
//        controller.log(message);
//    }

    public static void flush() {
        controller.flush();
    }

}
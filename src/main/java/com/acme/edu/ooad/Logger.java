package com.acme.edu.ooad;

import com.acme.edu.ooad.controller.LoggerController;
import com.acme.edu.ooad.message.*;

public class Logger {
    public static void flush() {
        LoggerController.flush();
    }

    public static void log(int message) {
        LoggerController.log(new IntegerMessage(message));
    }

    public static void log(int... integers) {
        for ( var integer: integers ) {
            LoggerController.log(new IntegerMessage(integer));
        }
    }

    public static void log(byte message) {
        LoggerController.log(new ByteMessage(message));
    }

    public static void log(char message) {
        LoggerController.log(new CharMessage(message));
    }

    public static void log(boolean message) {
        LoggerController.log(new BooleanMessage(message));
    }

    public static void log(String message) {
        LoggerController.log(new StringMessage(message));
    }

    public static void log(String... strings) {
        for ( var string : strings ) {
            LoggerController.log(new StringMessage(string));
        }
    }

    public static void log(Object message) {
        LoggerController.log(new ObjectMessage(message));
    }

}

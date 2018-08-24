package com.acme.edu.fascade;

import com.acme.edu.LoggerController;
import com.acme.edu.message.ByteMessage;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    private static LoggerController controller = new LoggerController(new ConsoleSaver());

    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

//    public void log(char message) {
//        controller.log(new CharMessage(message));
//    }
//
//    public void log(boolean message) {
//        controller.log(new BooleanMessage(message));
//    }
}

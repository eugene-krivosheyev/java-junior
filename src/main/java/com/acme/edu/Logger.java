package com.acme.edu;


import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
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


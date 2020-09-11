package com.acme.edu;


import com.acme.edu.exceptions.SaverException;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;


public class Logger {
    private static LoggerController controller = new LoggerController(System.out::println);

    public static void log(int message) throws SaverException {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) throws SaverException {
        controller.log(new StringMessage(message));
    }

    public static void flush() throws SaverException {
        controller.flush();
    }
}


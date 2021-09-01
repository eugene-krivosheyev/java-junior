package com.acme.edu;

import com.acme.edu.message.*;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.SaveException;


public class Logger {
    private static final LoggerController controller = new LoggerController(new FileSaver("demo.txt", "windows-1251", 512));
//    private static final LoggerController controller = new LoggerController(new ConsoleSaver());


    public static void log(int message) throws SaveException {
        controller.log(new IntMessage(message));
    }

    public static void log(int... messages) throws SaveException {
        for (int message : messages) {
            log(message);
        }
    }

    public static void log(byte message) throws SaveException {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) throws SaveException {
        controller.log(new CharMessage(message));
    }

    public static void log(String message) throws SaveException {
        controller.log(new StringMessage(message));
    }

    public static void log(String... messages) throws SaveException {
        for (String message : messages) {
            log(message);
        }
    }

    public static void log(boolean message) throws SaveException {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) throws SaveException {
        controller.log(new ReferenceMessage(message));
    }

    public static void flush() throws SaveException {
        controller.flush();
    }
}

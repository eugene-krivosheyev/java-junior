package com.acme.edu;

import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.command.CommandMessageString;
import com.acme.edu.exceptions.MaxValueReachedException;
import com.acme.edu.exceptions.NullCommandFlushException;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void log(int message) {
        try {
            loggerController.log(new CommandMessageInt(message));
        } catch (MaxValueReachedException e) {
            e.printStackTrace();
        }
    }

    public static void log(byte message) {
        //loggerController.log(new CommandMessageByte(message));
    }

    public static void log(char message) {
        //loggerController.log(new CommandMessageChar(message));
    }

    public static void log(boolean message) {
        //loggerController.log(new CommandMessageBoolean());
    }

    public static void log(Object message) {
        //loggerController.log(new CommandMessageObject(message));
    }

    public static void log(int[] array) {
    }

    public static void log(String message) {
        try {
            loggerController.log(new CommandMessageString(message));
        } catch (MaxValueReachedException e) {
            e.printStackTrace();
        }
    }

    public static void flush() {
        try {
            loggerController.flush();
        } catch (NullCommandFlushException e) {
            e.printStackTrace();
        }
    }
}

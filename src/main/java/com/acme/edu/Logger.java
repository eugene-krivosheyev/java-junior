package com.acme.edu;

import com.acme.edu.command.CommandMessageInt;
import com.acme.edu.command.CommandMessageString;
import com.acme.edu.saver.ConsoleSaver;

public class Logger {
    private static LoggerController loggerController = new LoggerController(new ConsoleSaver());

    public static void log(int message) {
        loggerController.log(new CommandMessageInt(message));
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
//        System.out.println(("primitives array: " + String.join(lineSeparator(), Arrays.toString(array)))
//                .replace('[', '{')
//                .replace(']', '}'));
    }

    public static void log(String message) {
        loggerController.log(new CommandMessageString(message));
    }

    public static void flush() {
        loggerController.flush();
    }
}

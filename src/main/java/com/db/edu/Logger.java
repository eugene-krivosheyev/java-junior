package com.db.edu;

import com.db.edu.message.*;
import com.db.edu.save.ConsoleSaver;
import com.db.edu.save.FileSaver;

public class Logger {

    /**
     * The list of prefixes
     */
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

    private static final Controller controller = new Controller(new FileSaver());

    private Logger() {
    }

    public static void flush() {
        controller.flush();
    }

    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(Integer ... args) {
        for (int x : args) {
            log(x);
        }
    }

    public static void log(byte message) {
        controller.log(new ByteMessage(message));
    }

    public static void log(char message) {
        controller.log(new CharMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }

    public static void log(String ... args) {
        for (String x : args) {
            log(x);
        }
    }

    public static void log(boolean message) {
        controller.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        controller.log(new ObjectMessage(message));
    }
}

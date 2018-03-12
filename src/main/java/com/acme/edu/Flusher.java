package com.acme.edu;

import com.acme.edu.savers.ConsolePrinter;
import com.acme.edu.savers.MessageSaver;

public class Flusher {
    private static String value;
    private static String prefix;
    private static String used;

    public static void flush() {
        if (value != null){
            MessageSaver printer = new ConsolePrinter();
            printer.output(prefix+value);
            value = null;
            prefix = null;
        }
    }
    public static void setValue(String value) {

        Flusher.value = value;
    }
    public static void setPrefix(String prefix) {
        Flusher.prefix = prefix;
    }

    public static String getUsed() {
        return used;
    }

    public static void setUsed(String used) {
        Flusher.used = used;
    }
}

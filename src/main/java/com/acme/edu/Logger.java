package com.acme.edu;

import com.acme.edu.savers.ConsoleSaver;

public class Logger {
   private static final LoggerController service = new LoggerController(new ConsoleSaver());

   private Logger() {

   }

    public static void log(int message) {
        service.log(message);
    }

    public static void log(byte message) {
        service.log(message);
    }

    public static void log(char message) {
        service.log(message);
    }

    public static void log(String message) {
        service.log(message);
    }

    public static void log(String... strings) {
        service.log(strings);
    }

    public static void setArrayToggle() {
        service.setArrayToggle();
    }

    public static void log(int... integers) {
        service.log(integers);
    }

    public static void log(int[][] integers) {
        service.log(integers);
    }

    public static void log(boolean message) {
        service.log(message);
    }

    public static void log(Object message) {
        service.log(message);
    }

    public static void flush() {
        service.flush();
    }
}

package com.acme.edu;

import static com.acme.edu.Logger.log;

public class Logger {
    private Logger() {
    }

    //=======================================
    private static Logger singletonLogger;
    static {
        singletonLogger = new Logger();
    }

    public static Logger getSingletonLogger() {
        return singletonLogger;
    }

    private static int state;

    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        Logger singletonLogger = Logger.singletonLogger;
    }
}

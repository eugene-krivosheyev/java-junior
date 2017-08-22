package com.acme.edu;

import sun.rmi.runtime.Log;

import static com.acme.edu.Logger.log;

public class Logger {
    public void m() {
        log(1);
    }

    //====================
    private static int state;

    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        Logger.log(1);

        Logger logger = new Logger();
        logger.log(1);
    }
}

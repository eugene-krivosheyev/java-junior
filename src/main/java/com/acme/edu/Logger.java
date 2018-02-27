package com.acme.edu;

//kdjghdfkgjhdfkgjhdfkgj
/*
gkjfhkgjfhg
лоралопралопр
лпораплорапл
 */

import sun.rmi.runtime.Log;

/**
 * Logs messages.
 * @author EK
 * @param
 * @see
 */
public class Logger {
    public static String state = null; //Global state
    public static final String MY_CONST = "";

    static {
        System.out.println(Logger.state);
        Logger.log(1, 2);
    }

    public static int log(int i1, int i2) {
        int localIntVar = 0; //local, auto, temp, stack
        System.out.println("primitive: " + localIntVar);
        return 0;
    }

    public static void log(byte message) {
        int localIntVar = 0;
        System.out.println("primitive: " + message);
        log(0);
    }

    public static void log(int message) {

    }


}

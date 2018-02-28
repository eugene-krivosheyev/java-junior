package com.acme.edu;

//kdjghdfkgjhdfkgjhdfkgj
/*
gkjfhkgjfhg
лоралопралопр
лпораплорапл
 */


import static com.acme.edu.Logger.*;
import static java.lang.Math.sin;

/**
 * Logs messages.
 * @author EK
 * @param
 * @see
 */
public class Logger {
    //region state
    public static String state = null; //Global state
    public static final String MY_CONST = "";
    //endregion

    static {
        System.out.println(Logger.state);
        log(1, 2);
    }

    public static int log(int i1, int i2) {
        int localIntVar = 0; //local, auto, temp, stack
        //region output
        System.out.println("primitive: " + localIntVar);
        return 0;
        //endregion
    }

    public static void log(byte message) {
        int localIntVar = 0;
        System.out.println("primitive: " + message);
        log(0);
    }

    public static void log(int message) {
        sin(0);
    }
}

class Demo {
    public static void main(String[] args) {
        log(1,1);
        log(0);
        System.out.println(MY_CONST);
    }
}

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
    public static final int LOWEST_PRICE = 0;
    //region state
    public static String state = null; //Global state
    public static final String MY_CONST = "";
    //endregion

    static {
        System.out.println(Logger.state);
        log(1, 2);
    }

    public static int log(int i1, int i2) {
        int localIntVar = LOWEST_PRICE; //local, auto, temp, stack
        //region output
        out(localIntVar);
        return LOWEST_PRICE;
        //endregion
    }

    private static void out(int localIntVar) {
        System.out.println("primitive: " + localIntVar);
    }

    public static void log(byte message) {
        int localIntVar = LOWEST_PRICE;
        out(message);
        log(LOWEST_PRICE);
    }

    public static void log(Object message, FLAG) {
        switch (FLAG) { //Cyclomatic complexity
            case: optiona1();
            case: optiona2();
        }
    }
}

class Demo {
    public static void main(String[] args) {
        log(1,1);
        log(0);
        System.out.println(MY_CONST);
    }
}

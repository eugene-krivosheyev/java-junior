package com.acme.edu;

//Single line
/*
Multi-line comment
 */

import static com.acme.edu.Logger.*;

/**
 * JavaDoc comment
 * Class Logger has unnecessarily comment.
 * <strong>bold</strong>
 * @see java.lang.String#String()
 */
public class Logger {
    private static int classState;

    public static void log(int message) {
        //region Main
        System.out.println("primitive: " + message);
        //endregion
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        System.out.println("string: " + message);
    }


    public static void log(boolean message) {
        System.out.println("primitive: " + message);
    }


    public static void log(Object message) {
        System.out.println("reference: " + message);
    }

    public static void main(String[] args) {
        System.out.println(1 + 2 + "3" + 4 + 5);
    }
}

class Superman {
    private static Superman theOne = new Superman();

    public static Superman getTheOne() {
        return theOne;
    }

    //=========

    private Superman() { }
}

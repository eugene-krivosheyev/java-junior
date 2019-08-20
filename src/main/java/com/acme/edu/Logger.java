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
    static {
        System.out.println("AAaaaa!!!!! WTF!!!!!!");
    }

    public static void log(int message) {
        //region Main
        System.out.println("primitive: " + message);
        //endregion
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        log(0);
    }
}

class Superman {
    private static Superman theOne;

    public static Superman getTheOne() {
        return theOne;
    }

    //=========

    private Superman() { }
}
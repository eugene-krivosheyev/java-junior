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

    static {
        System.out.println("AAaaaa!!!!! WTF!!!!!!");
    }

    public static void log(int message) {
        //region Main
        System.out.println("primitive: " + message);
        //endregion
    }

    public static void log(byte message) {
        int local = 0; //stack, temp, auto
        System.out.println(local);
        System.out.println("primitive: " + message);
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

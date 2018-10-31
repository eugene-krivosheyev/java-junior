package com.acme.edu;

import java.io.IOException;

/**
 * Text
 * <strong>flgjhdfkgjdhfgkjh</strong>
 * @see String#toString
 * @author
 * @since 16.18
 */
public class Logger {
    public static void log(int message) {
        printToConsole("primitive: " + message);
    }

    /**
     * 1. Contract:
     * Pre-conditions: param values, state
     * Post-conditions: side effect
     * Invariants: business rules
     *
     * 2. Architecture comments & whys?
     * - JDBC -> ORM, faster
     */
    public static int findMinimalElementInCollection(byte message) throws IOException {
        //region checks
        boolean a;
        boolean b;
        boolean c;
        boolean d;
        boolean isUserLoggedIn = a != b;
        //c == d -> is user registered?
        if (isUserLoggedIn && c == d) {

        }
        //endregion

        /*
        lfgkjdflkgjdlg
        lfkgjdlfgkjdlfkgj
        lfgkjdflgkjdflgk
         */
        printToConsole("primitive: " + message);
        printToConsole("primitive: " + message);
        printToConsole("primitive: " + message);
    }

    public static void main(String[] args) {
        printToConsole("HW!!!");
    }



    private static void printToConsole(String s) {
        System.out.println(s);
    }
}

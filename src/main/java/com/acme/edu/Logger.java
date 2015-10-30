package com.acme.edu;

public class Logger {

    //region constants
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";
    public static final String PRIMITIVE = "primitive: ";
    private static int value = 0;
    //endregion

    /**
     * Method call "print" with parameter int
     *
     * @param message
     */
    public static void log(int message) {

        if (message==0) {
            if (value>0) {
                print(PRIMITIVE + value);
                value=0;
            }
            print(PRIMITIVE + message);
        }
        value+=message;
    }

    /**
     * Method call "print" with parameter boolean
     *
     * @param message
     */

    public static void log(boolean message) {
        print(PRIMITIVE + message);
        value = 0;
    }

    /**
     * Method call "print" with parameter char
     *
     * @param message
     */
    public static void log(char message) {
        print(CHAR + message);
        value = 0;
    }

    /**
     * Method call "print" with parameter String
     *
     * @param message
     */
    public static void log(String message) {
        if (value>0) print("primitive: " + value);
        print(STRING + message);
        value = 0;
    }


    /**
     * Method call "print" with parameter Object
     *
     * @param message
     */
    public static void log(Object message) {
        print(REFERENCE + message);
        value = 0;
    }

    /**
     * Prints a String and then terminate the line.
     *
     * @param massege
     */
    private static void print(String massege) {
        System.out.println(massege);
    }
}

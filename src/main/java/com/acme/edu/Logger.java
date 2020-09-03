package com.acme.edu;

import org.jetbrains.annotations.NotNull;

import static java.lang.Math.random;
import static java.lang.Math.PI;

/**
 * jlkjlkjflghkj
 * <code>gfgjfkj</code>
 * <h1>fgkjfkjgh</h1>
 * @author EKR
 * @see AnotherClass
 * @deprecated
 * @param Inut param
 * @since
 */
public class Logger {
    public static final String PRIMITIVE_PREFIX = "primitive: ";

    static int var = 0; //class field, global var

    static {
        writeMessage("????");
    }

    public static final String FILE_NAME = "a.txt";
    //method for ....

    /** 10Msloc: 10к global vars
     * @throws
     * @param message
     */
    public static void log(int message) {
        writeMessage(Integer.toString(Logger.var));

        int var = 8; //local, temp, stack, auto
        System.out.println(var);
        writeMessage(PRIMITIVE_PREFIX + message);
        incrementC();
    }

    /*
    dghdkjfghkdfjg
    dkgjhdkjfghdfkgj
    kdfjgdkjghdkjgfh
     */
    public static void log(byte message) {
        random();
        writeMessage(decorateMessage(message));
    }

    @NotNull
    private static String decorateMessage(byte message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static void log(???? m) {
        writeMessage(PRIMITIVE_PREFIX + message);
    }

    private static void writeMessage(String s) {
        System.out.println(s);
    }

    /*
    int m(int p) { return 0; }
    byte m(int p) { return 0; }
    */

    public static void log(Object message) {
        if (message instanceof String) {
            if (message.getClass().getName().equals("String")) {
                //?????
            }
        }
    }
}
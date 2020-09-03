package com.acme.edu;

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
    static int var = 0; //class field, global var

    static {
        System.out.println("????");
    }

    public static final String FILE_NAME = "a.txt";
    //method for ....

    /** 10Msloc: 10к global vars
     * @throws
     * @param message
     */
    public static void log(int message) {
        System.out.println(Logger.var);

        int var = 8; //local, temp, stack, auto
        System.out.println(var);
        System.out.println("primitive: " + message);
    }

    /*
    dghdkjfghkdfjg
    dkgjhdkjfghdfkgj
    kdfjgdkjghdkjgfh
     */
    public static void log(byte message) {
        random();
        System.out.println(PI);
        System.out.println("primitive: " + message);
    }

    /*
    int m(int p) { return 0; }
    byte m(int p) { return 0; }
    */
}
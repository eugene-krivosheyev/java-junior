package com.acme.edu;

import java.io.File;

import static com.acme.edu.Logger.*;
import static java.io.File.separator;
import java.io.File;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    public static final String MY_SUPER_CONSTANT = "";
    /*
    xlkvhjkg
    лаорслиормс
     */

    //dfgdgfdg
    public static void logMySuperMessage(int message) {
        System.out.println("imits " + message);
        System.out.println("prits " + message);
//        System.out.println("prits " + message);
        System.out.println("primits " + message);
        System.out.println("prits " + message);
        System.out.println("pmits " + message);
        System.out.println("primits " + message);

    }

    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     * @param message РАПРапрдлпао апдлапорда рдаплро
     * @throws апорвл лопрл лорло
     */
    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    /**
     * public API
     */
    public static void logString(String message) {
        System.out.println(message);
    }


    public static void main(String[] args) {
        logString("HW!!!");
        Main.main();
        Main.counter = 1;
    }
}

class Main {
    public static int counter = 0;

    static {
        System.out.println("Hello!");
        counter = 1;
    }

    public void m() {

    }

    public static void main() {
        Main main = new Main();
        main.m();

        logString("HW!!!");
        sin(cos(abs(5)));
        System.out.println(separator);
    }
}

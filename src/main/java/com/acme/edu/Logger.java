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

    public static int globalState = 0;
    public int instanceState = 0;

    /*
    xlkvhjkg
    лаорслиормс
     */

    //dfgdgfdg


    public static String log(int... a) {
        return null;
    }

    public static void log(int foramlMessage) {
        foramlMessage = 2;
        int local = 0; //temp, stack, auto

        System.out.println("imits " + foramlMessage);
        System.out.println("prits " + foramlMessage);
//        System.out.println("prits " + foramlMessage);
        System.out.println("primits " + foramlMessage);
        System.out.println("prits " + foramlMessage);
        System.out.println("pmits " + foramlMessage);
        System.out.println("primits " + foramlMessage);
    }

    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     * @param message РАПРапрдлпао апдлапорда рдаплро
     */
    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    /**
     * public API
     */
    public static void log(String message) {
        System.out.println(message);
    }


    public static void main(String... args) {
        int local = 0;
        //kdjfhgkjfgh
        log(1);
//        Main.main();
//        Main.counter = 1;
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

    /**
     * java -Xss2m -Xms4G -Xmx4G
     */
    public static void main(String[] args) {
        int local = 0;
        main(new String[] {});

        int factualMessage = 1;
        Object o = new Object();

        System.out.println(factualMessage);
    }
}

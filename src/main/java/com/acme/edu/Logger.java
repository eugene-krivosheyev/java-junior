package com.acme.edu;

import static com.acme.edu.Logger.log;

public class Logger {
    public static void log(String... message) {
        for (String current : message) {
            System.out.print(current + " ");
        }
        System.out.println();
        System.out.println(message);
    }

    public static void log(String arg) {

    }

    public static int log(int arg) {
        return 0;
    }

    public static void main(String[] args) {
        String[] s = null;
        log(s); //null
    }
}

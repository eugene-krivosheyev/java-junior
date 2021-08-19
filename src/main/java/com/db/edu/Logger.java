package com.db.edu;

import java.io.PrintStream;

public class Logger {

    private static PrintStream OUT = System.out;

    Logger() {
    }


    public static PrintStream getOut() {
        return OUT;
    }

    public static void setOut(PrintStream OUT) {
        Logger.OUT = OUT;
    }

    public static void log(int i) {
        OUT.println("primitive: " + i);
    }

    public static void log(char ch) {
        OUT.println("char: " + ch);
    }

    public static void log(String s) {
        OUT.println("string: " + s);
    }

    public static void log(boolean b) {
        OUT.println("primitive: " + b);
    }

    public static void log(Object o) {
        OUT.println("reference: " + o);
    }
}

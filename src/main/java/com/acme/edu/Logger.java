package com.acme.edu;

public class Logger {
    public static void log(int message) {
        Printer printer = new Printer("primitive: ", message);
        printer.print();
    }

    public static void log(byte message) {
        Printer printer = new Printer("primitive: ", message);
        printer.print();
    }

    public static void log(char ch) {
        System.out.println("char: " + ch);
    }

    public static void log(String s) {
        System.out.println("string: " + s);
    }

    public static void log(boolean message) {
        Printer printer = new Printer("primitive: ", message);
        printer.print();
    }

    public static void log(Object message) {
        Printer printer= new Printer("reference: ", message);
        printer.print();
    }
}

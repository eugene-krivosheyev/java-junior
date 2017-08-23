package com.acme.edu;

public class Logger {
    public static void log(Object message) {

        if (message instanceof String) {
            System.out.println("string: " + message);
        } else if (message instanceof Character) {
            System.out.println("char: " + message);
        } else if (message instanceof Integer || message instanceof Boolean || message instanceof Byte) {
            System.out.println("primitive: " + message);
        } else {
            System.out.println("reference: " + message);
        }
    }
}

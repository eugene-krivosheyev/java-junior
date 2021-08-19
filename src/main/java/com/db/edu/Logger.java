package com.db.edu;

public class Logger {

    private static <T> void printLog(String name, T message) {
        System.out.println(name + message);
    }

    public static <T> void defineLog(T message)  {
        String prefix = null;
        if (message instanceof Integer || message instanceof Byte || message instanceof Boolean) {
            prefix = "primitive: ";
        } else if (message instanceof Character) {
            prefix = "char: ";
        } else if (message instanceof String) {
            prefix = "string: ";
        } else if (message instanceof Object) {
            prefix = "reference: ";
        }
        printLog(prefix, message);
    }
}

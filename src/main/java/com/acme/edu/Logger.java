package com.acme.edu;

public class Logger {
    public static void log(Object message) {
        String specification;

        if (message instanceof String) {
            specification = "string";
        } else if (message instanceof Character) {
            specification = "char";
        } else if (message instanceof Integer || message instanceof Boolean || message instanceof Byte) {
            specification = "primitive";
        } else {
            specification = "reference";
        }

        System.out.println(specification + ": " + message);
    }
}

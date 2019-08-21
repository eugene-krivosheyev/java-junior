package com.acme.edu;

import static com.acme.edu.Types.*;

public class Logger {
    public static void log(int message) {
        System.out.println(PRIMITIVE.getType() + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE.getType() + message);
    }

    public static void log(String message) {
        System.out.println(STRING.getType() + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE.getType() + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE.getType() + message);
    }

    public static void log(char message) {
        System.out.println(CHAR.getType() + message);
    }
}

enum Types {
    PRIMITIVE("primitive: "), STRING("string: "), REFERENCE("reference: "), CHAR("char: ");
    private String type;

    Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

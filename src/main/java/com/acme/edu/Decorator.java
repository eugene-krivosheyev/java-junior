package com.acme.edu;


import static com.acme.edu.Types.*;

public class Decorator {
    static String decoratePrimitive(String message) {
        return PRIMITIVE.getType() + message;
    }

    static String decorateString(String message) {
        return STRING.getType() + message;
    }

    static String decorateReference(String message) {
        return REFERENCE.getType() + message;
    }

    static String decorateChar(String message) {
        return CHAR.getType() + message;
    }
}
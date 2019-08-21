package com.acme.edu;

public class Logger {
    private static final String primitivePrefix = "primitive: ";
    private static final String stringPrefix = "string: ";
    private static final String charPrefix = "char: ";
    private static final String referencePrefix = "reference: ";


    public static void  log(Object message) {
        if (isPrimitive(message))
            decorateString(primitivePrefix, message);
        else if (message instanceof String)
            decorateString(stringPrefix, message);
        else if (message instanceof Character)
            decorateString(charPrefix, message);
        else
            decorateString(referencePrefix, message);
    }

    private static boolean isPrimitive(Object message){
        return  message instanceof Boolean || message instanceof Long || message instanceof Integer || message instanceof Byte;
    }


    private static void decorateString(String prefix, Object message) {
        System.out.println(prefix + message);
    }


}

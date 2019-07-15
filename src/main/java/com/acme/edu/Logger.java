package com.acme.edu;

import com.sun.istack.internal.NotNull;

public class Logger {

    private static void log(String type,String message){
        System.out.println(type+": "+ message);
    }

    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(char message) {
        log("char",message+"");
    }

    public static void log(String message) {
        log("string",String.valueOf(message));
    }

    public static void log(boolean message) {
        log("primitive",String.valueOf(message));
    }

    public static void log(Object message) {
        if(message != null)
            log("reference",message.toString());
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }
}

package com.db.edu;

public class Logger {

    private static <T> void printLog(String name, T message) {
        System.out.println(name + message);
    }

    public static <T> void defineLog(T message)  {
        if (message instanceof Integer || message instanceof Byte || message instanceof Boolean) {
            printLog("primitive: ", message);
        } else if (message instanceof Character) {
            printLog("char: ", message);
        } else if (message instanceof String) {
            printLog("string: ", message);
        } else if (message instanceof Object) {
            printLog("reference: ", message);
        }
    }
}

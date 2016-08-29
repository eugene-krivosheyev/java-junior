package com.acme.edu;

public class Logger {
    public static void log(int message) {
        assert message != 0 : "You shall not pass!!!!";
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        Logger.log(0);
    }
}

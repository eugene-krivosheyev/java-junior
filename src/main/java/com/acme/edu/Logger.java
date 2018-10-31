package com.acme.edu;
public class Logger {
    public static void log(int message) {
        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        System.out.println("primitive: " + message);
    }
}

public static void main(String[] args) {
    System.out.println("HW!!");
}
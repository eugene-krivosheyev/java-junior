package com.acme.edu;

public class Logger {
    public static void log(int message) {
        print("primitive: " + message);
//        System.out.println("primitive: " + message);
    }

    public static void log(byte message) {
        print("primitive: " + message);
//        System.out.println("primitive: " + message);
    }
    public static void log(boolean message) {
        print("primitive: " + message);
//        System.out.println("primitive: " + message);
    }
    public static void log(char message) {
        print("char: " + message);
//        System.out.println("primitive: " + message);
    }

    public static void main(String[] args) {
        log(1);
        log(0);
        log(-1);

        log((byte)1);
        log((byte)0);
        log((byte)-1);

        log('a');
        log('b');

        log(true);
        log(false);
    }
    public static void print(String str){
        System.out.println(str);
    }
}

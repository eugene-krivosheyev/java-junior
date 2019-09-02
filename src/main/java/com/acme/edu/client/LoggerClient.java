package com.acme.edu.client;

import java.util.Arrays;

public class LoggerClient {
    private static ClientProxy proxy = new ClientProxy();

    public static void log(int message) {
        proxy.run(message + "_int");
    }

    public static void log(byte message) {
        proxy.run(message + "_byte");
    }

    public static void log(String message) {
        proxy.run(message + "_string");
    }

    public static void log(String... messages) {
        proxy.run(Arrays.toString(messages) + "_stringVarArgs");
    }

    public static void log(Integer... messages) {
        proxy.run(Arrays.toString(messages) + "_integerVarArgs");
    }

    public static void log(int[][][][] messages) {
        proxy.run(Arrays.toString(messages) + "_integerArray4D");

    }

    public static void log(int[][] messages) {
        proxy.run(Arrays.toString(messages) + "_integerArray2D");
    }

    public static void log(int[] messages) {
        proxy.run(Arrays.toString(messages) + "_integerArray1D");
    }

    public static void log(boolean message) {
        proxy.run(message + "_boolean");
    }

    public static void log(Object message) {
        proxy.run(message + "_object");
    }

    public static void log(char message) {
        proxy.run(message + "_char");
    }

    public static void close() {
        proxy.run("close");
    }
}

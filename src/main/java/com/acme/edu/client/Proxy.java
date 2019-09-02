package com.acme.edu.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class Proxy {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static DataTransformer dataTransformer;

    static {
        try {
            dataTransformer = new DataTransformer(new Socket(HOST, PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(int message) {
        dataTransformer.transform(message + "_int");
    }

    public static void log(byte message) {
        dataTransformer.transform(message + "_byte");
    }

    public static void log(String message) {
        dataTransformer.transform(message + "_string");
    }

    public static void log(String... messages) {
        dataTransformer.transform(Arrays.toString(messages) + "_stringVarArgs");
    }

    public static void log(Integer... messages) {
        dataTransformer.transform(Arrays.toString(messages) + "_integerVarArgs");
    }

    public static void log(int[][][][] messages) {
        dataTransformer.transform(Arrays.toString(messages) + "_integerArray4D");

    }

    public static void log(int[][] messages) {
        dataTransformer.transform(Arrays.toString(messages) + "_integerArray2D");
    }

    public static void log(int[] messages) {
        dataTransformer.transform(Arrays.toString(messages) + "_integerArray1D");
    }

    public static void log(boolean message) {
        dataTransformer.transform(message + "_boolean");
    }

    public static void log(Object message) {
        dataTransformer.transform(message + "_object");
    }

    public static void log(char message) {
        dataTransformer.transform(message + "_char");
    }

    public static void close() {
        dataTransformer.transform("close");
    }
}

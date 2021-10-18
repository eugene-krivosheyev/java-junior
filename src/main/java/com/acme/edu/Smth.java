package com.acme.edu;

public class Smth {
    public static void main(String[] args) {
        Logger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        Logger.flush();
    }
}

package com.acme.edu.message;

public class BooleanMessage implements Message {

    private boolean message;
    private static boolean booleanUsage;
    private static boolean booleanBuffer;
    private static int booleanCounter;

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    public static boolean isBooleanUsage() {
        return booleanUsage;
    }

    public static boolean isBooleanBuffer() {
        return booleanBuffer;
    }

    public static int getBooleanCounter() {
        return booleanCounter;
    }

    @Override
    public void accumulate() {
        booleanUsage=true;
        booleanBuffer=message;
    }
    public static void flush(){
        booleanBuffer = false;
        booleanUsage = false;
        booleanCounter = 0;
    }
}

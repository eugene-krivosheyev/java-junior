package com.acme.edu.message;

import com.acme.edu.Flusher;

public class BooleanMessage implements Message {

    private boolean message;
    private static boolean booleanUsage;
    private static boolean booleanBuffer;
    private static int booleanCounter;

    public BooleanMessage(boolean message) {
        this.message = message;
    }

    @Override
    public boolean isUsed() {
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
        Flusher.setBuffer(booleanBuffer);
        Flusher.setUsage(booleanUsage);
        Flusher.setCounter(booleanCounter);
    }
    @Override
    public void flush(){
        booleanBuffer = false;
        booleanUsage = false;
        booleanCounter = 0;
    }
}

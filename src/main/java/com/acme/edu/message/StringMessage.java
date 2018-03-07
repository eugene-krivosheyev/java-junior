package com.acme.edu.message;

import com.acme.edu.Flusher;

public class StringMessage implements Message {

    private String message;
    private static boolean stringUsage;
    private static String stringBuffer="";
    private static int stringCounter;

    public StringMessage (String message) {
        this.message = message;
    }

    @Override
    public boolean isUsed() {
        return stringUsage;
    }

    public static String getStringBuffer() {
        return stringBuffer;
    }

    public static int getStringCounter() {
        return stringCounter;
    }

    @Override
    public void accumulate() {
        if (stringBuffer.equals("")){
            stringUsage = true;
        } else if (stringBuffer.equals(message)) {
            stringCounter++;
            stringUsage = true;
        }else {
            stringUsage = false;
        }
        stringBuffer = message;

        Flusher.setBuffer(stringBuffer);
        Flusher.setUsage(stringUsage);
        Flusher.setCounter(stringCounter);
    }
    @Override
    public void flush(){
        stringBuffer = "";
        stringCounter = 0;
        stringUsage = false;
    }
}

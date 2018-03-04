package com.acme.edu.message;

public class StringMessage implements Message {

    private String message;
    private static boolean stringUsage;
    private static String stringBuffer="";
    private static int stringCounter;

    public StringMessage (String message) {
        this.message = message;
    }

    public static boolean isStringUsage() {
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
    }
    public static void flush(){
        stringBuffer = "";
        stringCounter = 0;
        stringUsage = false;
    }
}

package com.acme.edu.message;


public class StringArrayMessage implements Message {
    private String[] message;
    private static boolean stringArrayUsage;

    public StringArrayMessage(String... message) {
        this.message = message;
    }

    public static boolean isStringArrayUsage() {
        return stringArrayUsage;
    }

    @Override
    public void accumulate() {
        stringArrayUsage = true;
        for (String mess:message) {
            System.out.println(mess);
        }
    }
    public static void flush(){
        stringArrayUsage = false;
    }
}

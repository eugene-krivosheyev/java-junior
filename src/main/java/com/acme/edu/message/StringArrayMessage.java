package com.acme.edu.message;


import com.acme.edu.Flusher;

public class StringArrayMessage implements Message {
    private String[] message;
    private static boolean stringArrayUsage;

    public StringArrayMessage(String... message) {
        this.message = message;
    }

    @Override
    public boolean isUsed() {
        return stringArrayUsage;
    }

    @Override
    public void accumulate() {
        stringArrayUsage = true;
        for (String mess:message) {
            System.out.println(mess);
        }
//        Flusher.setBuffer(intBuffer);
        Flusher.setUsage(stringArrayUsage);
    }
    @Override
    public void flush(){
        stringArrayUsage = false;
    }
}

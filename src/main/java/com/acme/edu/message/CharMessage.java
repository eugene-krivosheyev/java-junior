package com.acme.edu.message;

import com.acme.edu.Flusher;

public class CharMessage implements Message {

    private char message;
    private static boolean charUsage;
    private static char charBuffer;
    private static int charCounter;

    public CharMessage(char message) {
        this.message = message;
    }

    @Override
    public boolean isUsed() {
        return charUsage;
    }

    public static char getCharBuffer() {
        return charBuffer;
    }

    public static int getCharCounter() {
        return charCounter;
    }

    @Override
    public void accumulate() {
        if (charBuffer=='\0'){
            charUsage = true;
        }else if (charBuffer==message){
            charCounter++;
            charUsage = true;
        } else {
            charUsage = false;
        }
        charBuffer = message;
        Flusher.setBuffer(charBuffer);
        Flusher.setUsage(charUsage);
        Flusher.setCounter(charCounter);
    }

    @Override
    public void flush(){
        charBuffer='\0';
        charCounter = 0;
        charUsage = false;
    }
}
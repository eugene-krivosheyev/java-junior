package com.acme.edu.message;

public class CharMessage implements Message {

    private char message;
    private static boolean charUsage;
    private static char charBuffer;
    private static int charCounter;

    public CharMessage(char message) {
        this.message = message;
    }

    public static boolean isCharUsage() {
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
    }

    public static void flush(){
        charBuffer='\0';
        charCounter = 0;
        charUsage = false;
    }
}
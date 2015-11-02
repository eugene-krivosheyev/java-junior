package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class StringState implements LoggerState {

    private static final String STRING = "string: ";
    private static String previousLine = "";
    int buffer = 1;
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void log(String message) {
        if (previousLine.equals(message)){
            buffer++;
        }else if (previousLine != ""){
            print(STRING + previousLine);
        }
        previousLine = message;
    }

    @Override
    public void flush() {
        if (buffer == 1){
            print(STRING + previousLine);
        }else if(buffer > 1 ){
            print(String.format("%s%s (x%d)", STRING, previousLine, buffer));
        }
        buffer = 1;
        previousLine = "";
    }
}

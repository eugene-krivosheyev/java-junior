package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class IntState implements LoggerState{

    private static final String PRIMITIVE = "primitive: ";
    int buffer = 0;

    @Override
    public void print(String message) {
        System.out.println(PRIMITIVE + message);
    }

    @Override
    public void log(String message) {
        buffer += Integer.parseInt(message);
    }

    @Override
    public void flush() {
            print(String.valueOf(buffer));
            buffer = 0;
    }
}

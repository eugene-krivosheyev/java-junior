package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class SimplePrintState implements LoggerState{

    private static final String PRIMITIVE = "primitive: ";

    int buffer = 0;
    @Override
    public void print(String massege) {
        System.out.println(PRIMITIVE + massege);
    }

    @Override
    public void log(String message) {
        print(message);
    }

    @Override
    public void flush() {
        if (buffer != 0){
            print(String.valueOf(buffer));
            buffer = 0;
        }
    }
}

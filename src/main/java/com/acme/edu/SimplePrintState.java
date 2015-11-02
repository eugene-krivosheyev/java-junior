package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class SimplePrintState implements LoggerState{

    String buffer;
    @Override
    public void print(String massege) {
        System.out.println(massege);
    }

    @Override
    public void log(String message) {

    }

    @Override
    public void flush() {

    }
}

package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class SimplePrintState extends Printer implements LoggerState{

    private static final String PRIMITIVE = "primitive: ";

    @Override
    public void log(String message) {
        if (message == null){
            return;
        }
        Printer.print(PRIMITIVE +message);
    }

    @Override
    public void flush() {
    }
}

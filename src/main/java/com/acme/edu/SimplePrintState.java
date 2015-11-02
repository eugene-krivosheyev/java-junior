package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class SimplePrintState extends Printer implements LoggerState{

    private static final String PRIMITIVE = "primitive: ";
    private int buffer = 0;

    @Override
    public void log(String message) {
        Printer.print(PRIMITIVE +message);
    }

    @Override
    public void flush() {
        if (buffer != 0){
            Printer.print(PRIMITIVE + String.valueOf(buffer));
            buffer = 0;
        }
    }
}

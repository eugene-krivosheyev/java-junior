package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class IntState extends Printer implements LoggerState{

    private static final String PRIMITIVE = "primitive: ";
    private int buffer = 0;

    @Override
    public void log(String message) {
        checkMaxAndOverFlow(Integer.parseInt(message));
        buffer += Integer.parseInt(message);
    }

    @Override
    public void flush() {
            Printer.print(PRIMITIVE + String.valueOf(buffer));
            buffer = 0;
    }

    private void checkMaxAndOverFlow(int message) {
        if (message == Integer.MAX_VALUE || message == Byte.MAX_VALUE) {
            flush();
        }
        if (message + buffer < 0){
            flush();
        }
    }
}

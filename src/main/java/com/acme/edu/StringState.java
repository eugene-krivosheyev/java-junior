package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class StringState extends Printer implements LoggerState {

    private static final String STRING = "string: ";
    private static String previousLine = "";
    private int buffer = 1;

    @Override
    public void log(String message) {
        if (message == null){
            return;
        }
        if (previousLine.equals(message)){
            buffer++;
        }else if (previousLine != ""){
            Printer.print(STRING + previousLine);
        }
        previousLine = message;
    }

    @Override
    public void flush() {
        if (buffer == 1){
            Printer.print(STRING + previousLine);
        }else if(buffer > 1 ){
            Printer.print(String.format("%s%s (x%d)", STRING, previousLine, buffer));
        }
        buffer = 1;
        previousLine = "";
    }
}

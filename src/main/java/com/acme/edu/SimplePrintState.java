package com.acme.edu;

/**
 * Created by Павел on 02.11.2015.
 */
public class SimplePrintState implements LoggerState{
    Printer printer = new Printer();
    @Override
    public void log(String message) {
        if (message == null){
            return;
        }
        printer.print(PRIMITIVE +message);
    }

    //Утечка абстракции
    @Override
    public void flush() {
        return;
    }
}

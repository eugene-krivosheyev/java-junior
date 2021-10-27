package com.acme.edu.model.printer;

import com.acme.edu.model.exception.LoggerException;

public class ConsolePrinter implements Printer{
    private final String message;

    public ConsolePrinter(String message) {
        this.message = message;
    }

    @Override
    public void print() throws LoggerException {
        System.out.println(message);
    }
}

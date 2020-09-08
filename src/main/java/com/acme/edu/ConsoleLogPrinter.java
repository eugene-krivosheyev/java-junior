package com.acme.edu;

public class ConsoleLogPrinter implements ILogPrinter {
    private String buffer = "";
    public void writeBuffer(String line)
    {
        buffer = buffer + line + System.lineSeparator();
    }

    public void print() {
        System.out.println(buffer);
    }

}

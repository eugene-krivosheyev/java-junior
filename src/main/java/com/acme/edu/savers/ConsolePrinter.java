package com.acme.edu.savers;

public final class ConsolePrinter implements MessageSaver{
    @Override
    public void output(String message) {
        System.out.println(message);
    }
}

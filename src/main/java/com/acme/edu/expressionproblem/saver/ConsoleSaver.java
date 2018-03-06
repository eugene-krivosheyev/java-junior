package com.acme.edu.expressionproblem.saver;

public class ConsoleSaver implements LoggerSaver {
    @Override
    public void save(String formattedMessage) {
        System.out.println(formattedMessage);
    }
}

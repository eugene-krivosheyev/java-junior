package com.acme.edu.saver;

public class ConsoleLoggerSaver implements LoggerSaver {
    @Override
    public void save (String msg){
        if (checkNull(msg)) return;
        System.out.println(msg);
    }
}

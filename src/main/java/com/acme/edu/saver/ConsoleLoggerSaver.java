package com.acme.edu.saver;

public class ConsoleLoggerSaver extends LoggerSaver {
    @Override
    protected void saveOp(String msg){
        System.out.println(msg);
    }
}

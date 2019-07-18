package com.acme.edu;

public class ConsoleLoggerSaver {
    public void save(Accumulator localState){
        System.out.println(localState.getCurrentMessage());
        localState.clean();
    }
}

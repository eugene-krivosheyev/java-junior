package com.acme.edu.saver;

import com.acme.edu.Accumulator;

public class ConsoleLoggerSaver {
    public void save(Accumulator localState){
        System.out.println(localState.getCurrentMessage());
        localState.clean();
    }
}

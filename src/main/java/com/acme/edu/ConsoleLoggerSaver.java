package com.acme.edu;


public class ConsoleLoggerSaver implements Saver{
    @Override
    public void save(String decoratedOutput) {
        if (isNull(decoratedOutput))
            return;
        System.out.print(decoratedOutput);
    }

    @Override
    public boolean isNull(String decoratedOutput) {
        return  (decoratedOutput == null);
    }
}

package com.acme.edu.saver;


import com.acme.edu.loggerexceptions.LoggerErrors;
import com.acme.edu.loggerexceptions.LoggerSaverException;

public class ConsoleLoggerSaver implements Saver{
    @Override
    public void save(String decoratedOutput) throws LoggerSaverException {
        if (isNull(decoratedOutput))
            throw new LoggerSaverException("decoratedOutput was null", LoggerErrors.NULL_INPUT);
        System.out.print(decoratedOutput);
    }

    @Override
    public boolean isNull(String decoratedOutput) {
        return  (decoratedOutput == null);
    }
}

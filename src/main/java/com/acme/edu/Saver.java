package com.acme.edu;

import com.acme.edu.loggerexceptions.LoggerSaverException;

public interface Saver {
    void save(String decoratedOutput) throws LoggerSaverException;
    public boolean isNull(String decoratedOutput);
}

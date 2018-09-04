package com.acme.edu.saver;

import com.acme.edu.loggerexceptions.LoggerSaverException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Saver {
    void save(String decoratedOutput) throws LoggerSaverException;
    public boolean isNull(String decoratedOutput);
}

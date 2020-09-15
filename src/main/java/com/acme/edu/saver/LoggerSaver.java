package com.acme.edu.saver;


import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.exceptions.SaverException;

public interface LoggerSaver {
    void save(String message) throws SaverException;
}

package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;

public interface LoggerSaver {
    void save(String representation) throws SaveException;
}



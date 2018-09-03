package com.acme.edu.saver;

import com.acme.edu.loggerexceptions.SaverException;

public interface Saver {
    void save(String message) throws SaverException;
}

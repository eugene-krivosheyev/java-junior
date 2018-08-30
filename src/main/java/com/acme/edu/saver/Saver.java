package com.acme.edu.saver;

import com.acme.edu.loggerexceptions.SaverExceptions;

public interface Saver {
    void save(String message) throws SaverExceptions;
}

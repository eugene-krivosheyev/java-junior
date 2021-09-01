package com.acme.edu.savers;

import com.acme.edu.exceptions.FileSaverException;

public class ConsoleSaver extends AbstractSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }

    @Override
    public void close() throws FileSaverException {
        return;
    }
}

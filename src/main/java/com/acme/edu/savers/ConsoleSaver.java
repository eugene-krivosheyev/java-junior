package com.acme.edu.savers;

import com.acme.edu.exceptions.FileSaverException;
import com.acme.edu.exceptions.SaverException;

public class ConsoleSaver extends AbstractSaver {
    public ConsoleSaver() throws SaverException {
        super();
    }

    @Override
    public void save(String message) throws SaverException {
        System.out.println(message);
    }

    @Override
    public void close() throws SaverException {
        return;
    }
}

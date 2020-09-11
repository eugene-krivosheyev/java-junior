package com.acme.edu.saver;

import com.acme.edu.exceptions.FileLoggerSaverException;

public class FileLoggerSaver implements LoggerSaver{

    @Override
    public void save(String message) throws FileLoggerSaverException {
        if(message==null){throw new FileLoggerSaverException("ne");}
        System.out.println(message);

    }
}

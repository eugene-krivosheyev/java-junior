package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;

import java.security.InvalidParameterException;

public class ConsoleSaver implements LoggerSaver {
    @Override
    public void save(String representation) throws SaveException {
        try {
            if (!"".equals(representation)) {
                System.out.println(representation);
            } else {
                throw new InvalidParameterException();
            }
        } catch(InvalidParameterException e) {
            e.printStackTrace();
            throw new SaveException("received empty message", e);
        }
    }
}

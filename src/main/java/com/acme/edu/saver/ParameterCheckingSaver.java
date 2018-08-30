package com.acme.edu.saver;

import com.acme.edu.LogException;
import com.acme.edu.saver.Saver;

public class ParameterCheckingSaver implements Saver {
    @Override
    public void save(String decoratedString) throws LogException {
        if (decoratedString == null) {
            throw new LogException("try to print null string", 1001);
        };
    }
}

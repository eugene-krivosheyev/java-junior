package com.acme.edu;

import java.io.IOException;

public class ParameterCheckingSaver implements Saver {
    @Override
    public void save(String decoratedString) throws LogException {
        if (decoratedString == null) {
            throw new LogException("try to print null string", 1001);
        };
    }
}

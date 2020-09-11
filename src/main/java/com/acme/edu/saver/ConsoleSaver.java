package com.acme.edu.saver;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
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
            throw new SaveException();
        }
    }
}

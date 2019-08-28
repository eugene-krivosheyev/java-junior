package com.acme.edu.savers;

import com.acme.edu.exceptions.SaverException;

public class ConsoleSaver implements Saver {
    public void save(String message) throws SaverException {
        System.out.println(message);
    }
}
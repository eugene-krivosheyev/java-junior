package com.acme.edu.savers;

import com.acme.edu.exceptions.SaverException;

public interface Saver {
    void save(String message) throws SaverException;
}

package com.acme.edu.saver;

import com.acme.edu.controller.LogOperationException;

import static java.util.Objects.isNull;

/**
 * Created by Java_1 on 27.08.2018.
 */
public class Saver {

    public void save(String message) throws SaveException, LogOperationException {

    }


    public boolean checkIsNull(String message) throws SaveException {
        if (isNull(message)) {
           throw new SaveException("message is null",228);
        }
        return isNull(message);
    }

}
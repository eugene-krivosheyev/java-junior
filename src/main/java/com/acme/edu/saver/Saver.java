package com.acme.edu.saver;

import static java.util.Objects.isNull;

/**
 * Created by Java_1 on 27.08.2018.
 */
public class Saver {
    public boolean checkIsNull(String message) throws SaveException {
        if (isNull(message)) {
           throw new SaveException("message is null",228);
        }
        return isNull(message);
    }

}
package com.acme.edu.saver;

import com.acme.edu.LogException;

/**
 * Created by Java_12 on 29.08.2018.
 */
public interface Saver {
    void save(String decoratedString) throws LogException;
}

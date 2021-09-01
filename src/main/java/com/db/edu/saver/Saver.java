package com.db.edu.saver;

import com.db.edu.LoggerException;

import java.io.FileNotFoundException;

public interface Saver {

    void save(String s) throws LoggerException;
}

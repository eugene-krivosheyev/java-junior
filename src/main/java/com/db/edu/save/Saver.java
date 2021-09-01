package com.db.edu.save;

import com.db.edu.SaverException;

public interface Saver {

    void save(String message) throws SaverException;
}

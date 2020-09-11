package com.acme.edu.saver;

import com.acme.edu.exception.SaverException;
import com.acme.edu.message.Message;

public interface Saver {
    void save(Message toLog) throws SaverException;
}

package com.acme.edu.saver;

import com.acme.edu.exception.SaveException;
import com.acme.edu.message.Message;

public interface Saver {
    void save(Message message) throws SaveException;
}

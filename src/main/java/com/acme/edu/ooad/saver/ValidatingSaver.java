package com.acme.edu.ooad.saver;

import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.Message;

public abstract class ValidatingSaver implements Saver {

    @Override
    public void save(Message message) throws SaveException {
        if (message == null) throw new SaveException(new IllegalArgumentException("Message to save is null"));
        if (message.getBody().isEmpty())
            throw new SaveException(new IllegalArgumentException("Message to save is empty"));
    }
}

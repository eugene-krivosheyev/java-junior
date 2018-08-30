package com.acme.edu.saver;

import com.acme.edu.loggerexceptions.MessageException;
import com.acme.edu.loggerexceptions.SaveException;
import com.acme.edu.loggerexceptions.SaverExceptions;

import java.util.Objects;

public abstract class LoggerSaver implements Saver {
    @Override
    public void save(String message) throws SaverExceptions {
        if (Objects.isNull(message)) {
            throw new MessageException("Call save with null message");
        }
        saveOp(message);
    }

    protected abstract void saveOp(String message) throws SaveException;
}

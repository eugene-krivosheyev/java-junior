package com.acme.edu;

import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.message.DefaultMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.LoggerSaver;

import java.util.Arrays;

public class LoggerController {
    private Iterable<LoggerSaver> savers;
    private LoggerMessage currentMessage = new DefaultMessage();

    public LoggerController(LoggerSaver... saver) {
        this.savers = Arrays.asList(saver);
    }


    public void log(LoggerMessage newMessage) throws SaverException {
        if (currentMessage.isSameType(newMessage) && currentMessage.isNotOverflowed(newMessage)) {
            currentMessage = currentMessage.accumulate(newMessage);
        } else {
            flush();
            currentMessage = newMessage;
        }
    }

    public void flush() throws SaverException{
        try {
            for(LoggerSaver s: savers) {
                s.save(currentMessage.getMessage());
            }
        } catch (SaverException e) {
            throw new SaverException("Can not save file!", e);
        } finally {
            currentMessage = new DefaultMessage();
        }
    }
}

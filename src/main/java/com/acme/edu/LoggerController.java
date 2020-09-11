package com.acme.edu;

import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.exceptions.SaverException;
import com.acme.edu.message.DefaultMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver saver;
    private LoggerMessage currentMessage = new DefaultMessage();

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }


    public void log(LoggerMessage newMessage) throws SaverException {
        SaverException saverException = null;
        if (currentMessage.isSameType(newMessage) && currentMessage.isNotOverflowed(newMessage)) {
            currentMessage = currentMessage.accumulate(newMessage);
        } else {
            try {
                saver.save(currentMessage.getMessage());
            } catch (FileLoggerSaverException e) {
                saverException = new SaverException("Can not save file!", e);
                throw saverException;
            } finally {
                currentMessage = newMessage;
            }
        }
    }

    public void flush() throws SaverException{
        SaverException saverException = null;
        try {
            saver.save(currentMessage.getMessage());
        } catch (FileLoggerSaverException e) {
            saverException = new SaverException("Can not save file!", e);
            throw saverException;
        } finally {
            currentMessage = new DefaultMessage();
        }
//        saver.save(currentMessage.getMessage());
//        currentMessage = new DefaultMessage();
    }
}

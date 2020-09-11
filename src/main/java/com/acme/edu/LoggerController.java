package com.acme.edu;

import com.acme.edu.message.DefaultMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.FileLoggerSaver;
import com.acme.edu.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver saver;
    private LoggerMessage currentMessage = new DefaultMessage();

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }


    public void log(LoggerMessage newMessage) {
        if (currentMessage.isSameType(newMessage) && currentMessage.isNotOverflowed(newMessage)) {
            currentMessage = currentMessage.accumulate(newMessage);
        } else {
            try {
                saver.save(currentMessage.getMessage());
            } catch ( FileLoggerSaverException e) {
                logException = new LogException("Can not save file!", e);
                throw logException;
            } finally {

            }
            currentMessage = newMessage;
        }
    }

    public void flush() {
        saver.save(currentMessage.getMessage());
        currentMessage = new DefaultMessage();
    }
}

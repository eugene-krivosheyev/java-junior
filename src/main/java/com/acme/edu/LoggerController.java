package com.acme.edu;

import com.acme.edu.loggerexceptions.LoggerSaverException;
import com.acme.edu.message.Message;

public class LoggerController {
    private Message currentMessage;
    private ConsoleLoggerSaver saver;

    public LoggerController(ConsoleLoggerSaver consoleLoggerSaver) {
        this.saver = consoleLoggerSaver;
    }

    public void log(Message message) throws LoggerSaverException {
        if (currentMessage == null) {
            currentMessage = message;
            return;
        }
        if (currentMessage.isSameTypeOf(message)) {
            currentMessage = currentMessage.accumulate(message);
        } else {
            saver.save(currentMessage.getDecoratedMessage());
            currentMessage = message;
        }
    }
}

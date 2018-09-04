package com.acme.edu;

import com.acme.edu.loggerexceptions.*;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleLoggerSaver;

public class LoggerController {
    private Message currentMessage;
    private ConsoleLoggerSaver saver;

    public LoggerController(ConsoleLoggerSaver consoleLoggerSaver) {
        this.saver = consoleLoggerSaver;
    }

    public void log(Message message) throws LoggingException {
        if (currentMessage == null) {
            currentMessage = message;
            return;
        }
        if (currentMessage.isSameTypeOf(message)) {

            try {
                currentMessage = currentMessage.accumulate(message);
            } catch (AccumulatingException e) {
                throw new LoggingException(LoggerErrors.UNABLE_ACCUMULATE, e);
            }
        } else {
            try {
                saver.save(currentMessage.getDecoratedMessage());
            } catch (LoggerDecoratorException e) {
                throw new LoggingException(LoggerErrors.UNABLE_DECORATE, e);
            } catch (LoggerSaverException e) {
                throw new LoggingException(LoggerErrors.UNABLE_SAVE_CONSOLE, e);
            }
            currentMessage = message;
        }
    }
}

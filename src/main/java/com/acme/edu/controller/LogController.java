package com.acme.edu.controller;

import com.acme.edu.loggerexceptions.SaverExceptions;
import com.acme.edu.messagelog.BlankMessage;
import com.acme.edu.messagelog.LoggerDecorator;
import com.acme.edu.messagelog.Message;
import com.acme.edu.saver.Saver;

public class LogController {
    private Message previousMessage = new BlankMessage();
    private final Saver saver;
    private final LoggerDecorator decorator;

    public LogController(Saver saver, LoggerDecorator decorator) {
        this.saver = saver;
        this.decorator = decorator;
    }

    public int log(Message message) {
        if (previousMessage.canBeAccumulated(message)) {
            previousMessage = previousMessage.accumulate(message);
        } else {
                int isFlushSuccess = flush();
                if (isFlushSuccess == 0){
                    previousMessage = message;
                }
                return isFlushSuccess;
            }
        return 0;
    }

    public int flush() {
        if (previousMessage instanceof BlankMessage) return 0;
        try {
            saver.save(previousMessage.getFormattedMessage(decorator));
        } catch (SaverExceptions saverExceptions) {
            saverExceptions.printStackTrace();
            return saverExceptions.getCode();
        }
        previousMessage = new BlankMessage();
        return 0;
    }
}

package com.acme.edu.controller;

import com.acme.edu.loggerexceptions.AccumulateException;
import com.acme.edu.loggerexceptions.SaverExceptions;
import com.acme.edu.messagelog.BlankMessage;
import com.acme.edu.messagelog.LoggerDecorator;
import com.acme.edu.messagelog.Message;
import com.acme.edu.saver.Saver;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class LogController {
    private Collection<Message> previousMessages;
    private Message lastMessage = new BlankMessage();
    private final Saver saver;
    private final LoggerDecorator decorator;

    public LogController(Saver saver, LoggerDecorator decorator) {
        this.previousMessages = new LinkedList<>();
   //     this.previousMessages.add(new BlankMessage());
        this.saver = saver;
        this.decorator = decorator;
    }

    public int log(Message message) {
        if (lastMessage.canBeAccumulated(message)) {
            previousMessages.add(message);
            lastMessage = message;
        } else {
            int isFlushSuccess = flush();
            if (isFlushSuccess == 0) {
                lastMessage = message;
                previousMessages.clear();
                previousMessages.add(lastMessage);
            }
            return isFlushSuccess;
        }
        return 0;
    }

    public int flush() {
        if (lastMessage instanceof BlankMessage) return 0;

        try {
            saver.save(
                    previousMessages.stream()
                            .reduce(Message::accumulate)
                            .get()
                            .getFormattedMessage(decorator)
            );
        } catch (SaverExceptions saverExceptions) {
            saverExceptions.printStackTrace();
            return saverExceptions.getCode();
        }

        lastMessage = new BlankMessage();
        previousMessages.clear();
        return 0;
    }
}

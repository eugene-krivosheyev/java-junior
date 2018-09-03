package com.acme.edu.controller;

import com.acme.edu.loggerexceptions.AccumulationException;
import com.acme.edu.loggerexceptions.SaverException;
import com.acme.edu.messagelog.BlankMessage;
import com.acme.edu.messagelog.LoggerDecorator;
import com.acme.edu.messagelog.Message;
import com.acme.edu.saver.Saver;

import java.util.Collection;
import java.util.LinkedList;

public class LogController {
    private Collection<Message> previousMessages;
    private Message lastMessage = new BlankMessage();
    private final Saver saver;
    private final LoggerDecorator decorator;

    public LogController(Saver saver, LoggerDecorator decorator) {
        this.previousMessages = new LinkedList<>();
        this.saver = saver;
        this.decorator = decorator;
    }

    public int log(Message message) {
        if (lastMessage.canBeAccumulated(message)) {
            previousMessages.add(message);
        } else {
            try {
                flush();
                previousMessages.clear();
                previousMessages.add(lastMessage);
            } catch (SaverException e) {
                return e.getCode();
            }
        }
        lastMessage = message;
        return 0;
    }

    public void flush() throws SaverException {
        Collection<Message> accumulatedMessages = new LinkedList<>();
        previousMessages.stream()
                .reduce((m1, m2) -> {
                            try {
                                return m1.accumulate(m2);
                            } catch (AccumulationException e) {
                                accumulatedMessages.add(m1);
                                return m2;
                            }
                        }
                ).ifPresent(accumulatedMessages::add);

        for (Message message : accumulatedMessages) {
            saver.save(message.getFormattedMessage(decorator));
        }
        lastMessage = new BlankMessage();
    }
}

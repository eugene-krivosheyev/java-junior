package com.acme.edu.ooad.controller;

import com.acme.edu.ooad.exception.FlushException;
import com.acme.edu.ooad.exception.LogException;
import com.acme.edu.ooad.exception.SaveException;
import com.acme.edu.ooad.message.EmptyMessage;
import com.acme.edu.ooad.message.Message;
import com.acme.edu.ooad.saver.ValidatingSaver;

public class LoggerController {
    ValidatingSaver saver;
    Message lastLoggedMessage = new EmptyMessage();

    public LoggerController(ValidatingSaver saver) {
        this.saver = saver;
    }

    public void setSaver(ValidatingSaver saver) {
        this.saver = saver;
    }

    public void flush() throws FlushException {
        try {
            saver.save(lastLoggedMessage);
            lastLoggedMessage = new EmptyMessage();
        } catch (SaveException e) {
            throw new FlushException(e);
        }
    }

    public void log(Message message) throws LogException {
        Message messageToPrint = lastLoggedMessage.getInstanceToPrint(message);
        lastLoggedMessage = lastLoggedMessage.getNewInstance(message);

        if (messageToPrint != null) {
            try {
                saver.save(messageToPrint);
            } catch (SaveException e) {
                throw new LogException(e);
            }
        }
    }
}

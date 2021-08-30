package com.db.education.app.controller;

import com.db.education.app.exception.LogException;
import com.db.education.app.exception.SaveException;
import com.db.education.app.message.EmptyMessage;
import com.db.education.app.message.Message;
import com.db.education.app.saver.Saver;

/**
 * LoggerController accumulates logging logic for the application by delegating accumulation
 * and saving to external objects.
 *
 * Logger controller stores state of the application and controls proper flushing of accumulated
 * data.
 */
public class LoggerController {

    private static final Message EMPTY_MESSAGE = new EmptyMessage();

    private final Saver saver;
    private Message lastMessage = EMPTY_MESSAGE;

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void accept(Message message) throws LogException, SaveException {
            processMessage(message);
    }

    public void flush() throws SaveException {
        try {
            flushMessage();
        } catch (SaveException e) {
            throw new SaveException("Unable to save message: ", e);
        }
    }

    private void processMessage(Message message) throws LogException, SaveException {
        try {
            if (message == null) {
                throw new NullPointerException("No message received");
            } else if (message.isEmptyMessage()) {
                throw new IllegalArgumentException("Empty message received");
            }
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new LogException("Message was not logged! " + ex.getMessage(), ex);
        }

        lastMessage = lastMessage.accumulate(message);

        if (lastMessage.needsFlush()) {
            Message last = lastMessage;
            flush();
            if (!(message == last)) {
                lastMessage = lastMessage.accumulate(message);
            }
        }
    }

    private void flushMessage() throws SaveException {
        if (lastMessage.isEmptyMessage()) return;

        saver.save(lastMessage);
        lastMessage = EMPTY_MESSAGE;
    }
}

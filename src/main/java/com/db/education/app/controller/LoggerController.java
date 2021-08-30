package com.db.education.app.controller;

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

    public void accept(Message message) {
        try {
            processMessage(message);
        } catch (NullPointerException npe) {
            System.out.println("FATAL ERROR: message was not saved" + npe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println("FATAL ERROR: " + iae.getMessage());
        }
    }

    public void flush() {
        try {
            flushMessage();
        } catch (SaveException e) {
            System.out.println("Unable to save message: " + e.getCause());
        }
    }

    private void processMessage(Message message) {
        if (message == null) {
            throw new NullPointerException("No message received");
        } else if (message.isEmptyMessage()) {
            throw new IllegalArgumentException("Empty message received");
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

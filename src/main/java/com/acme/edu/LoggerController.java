package com.acme.edu;

import com.acme.edu.exception.FlushLogException;
import com.acme.edu.exception.LoggerException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.message.AbstractMessage;
import com.acme.edu.saver.Saver;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for log messages. Automatically decides whether to put
 * messages into message queue or to call flush on message queue.
 */
public class LoggerController {
    private final Saver saver;
    private AbstractMessage currentState = null;
    private final List<AbstractMessage> messageQueue = new ArrayList<>();

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    /**
     * Performs collecting messages of the same type to message queue
     * and flushing message queue in case of new type arrival.
     *
     * @param message AbstractMessage to be logged
     */
    public void log(AbstractMessage message) throws LoggerException {
        if (!messageQueue.isEmpty() && !currentState.isSameType(message)) {
            flush();
        }
        messageQueue.add(message);
        currentState = message;
    }

    /**
     * Saves collected messages from message queue and clears messages buffer.
     */
    public void flush() throws LoggerException {
        try {
            AbstractMessage firstToLog = messageQueue.get(0);
            firstToLog.prepareMessage(messageQueue);
            saver.save(firstToLog);
        } catch (IndexOutOfBoundsException e) {
            throw new FlushLogException("Message log is empty! See: ", e);
        } catch (Exception e) {
            throw new SaveException("Message cannot be saved correctly", e);
        } finally {
            messageQueue.clear();
        }
    }
}

package com.acme.edu;

import com.acme.edu.exception.FlushLogException;
import com.acme.edu.exception.LoggerException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.message.AbstractMessage;
import com.acme.edu.saver.Saver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Controller for log messages. Automatically decides whether to put
 * messages into message queue or to call flush on message queue.
 */
public class LoggerController {
    private final Collection<Saver> savers;
    private AbstractMessage currentState = null;
    private final List<AbstractMessage> messageQueue = new ArrayList<>();

    public LoggerController(Saver... savers) {
        this.savers = Arrays.asList(savers);
    }

    /**
     * Performs collecting messages of the same type to message queue
     * and flushing message queue in case of new type arrival.
     *
     * @param message AbstractMessage to be logged
     */
    public void log(AbstractMessage message) throws LoggerException {
        if (!this.messageQueue.isEmpty() && !this.currentState.isSameType(message)) {
            flush();
        }
        this.messageQueue.add(message);
        this.currentState = message;
    }

    /**
     * Saves collected messages from message queue and clears messages buffer.
     */
    public void flush() throws LoggerException {
        try {
            AbstractMessage firstToLog = messageQueue.get(0);
            firstToLog.prepareMessage(messageQueue);
            this.savers.forEach(saver -> {
                try {
                    saver.save(firstToLog);
                } catch (SaveException e) {
                    e.printStackTrace();
                }
            });
            firstToLog.clearMessageBuffer();
        } catch (IndexOutOfBoundsException e) {
            throw new FlushLogException("Message log is empty! See: ", e);
        } finally {
            messageQueue.clear();
        }
    }

    /**
     * Flushes leaving messages and closes all savers.
     */
    public void end() throws LoggerException {
        flush();

        this.savers.forEach(saver -> {
            try {
                saver.closeWriter();
            } catch (SaveException e) {
                e.printStackTrace();
            }
        });
    }
}
